package hotelManagement.service.guestroom;

import hotelManagement.model.dto.room.RoomReservationDto;
import hotelManagement.model.dto.room.RoomSearchDto;
import hotelManagement.model.entity.room.RoomReservationEntity;
import hotelManagement.model.repository.room.RoomReservationEntityRepository;
import hotelManagement.service.getListInterface.GetListInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RoomReservationService implements GetListInterface<RoomSearchDto> {

    @Autowired
    RoomReservationEntityRepository roomReservationEntityRepository;
    /*
    * 객실 예약 리스트 정보 호출 메서드
    * */
    @Override
    public Map<String,Object> getList( RoomSearchDto roomSearchDto ){

        // 모든 예약 정보 호출
        List<RoomReservationEntity> entities= roomReservationEntityRepository.findAll();
        // 검색에 따른 스트림 메서드 호출
        // onSearch() 호출 결과(stream 객체 반환됨) 리스트화 시켜서 entities에 저장
        entities = onSearch( roomSearchDto , entities ).collect(Collectors.toList());
        // stream 생성
        Stream<RoomReservationEntity> entityStream = entities.stream();

        // 정렬 요청 시 정렬 메서드 호출 결과 반환
        if( !roomSearchDto.getPageAndSort().getCname().isEmpty() ) {
            // onSort() <- 정렬된 스트림 객체 반환, collect()로 리스트화 시켜서 entities에 저장
            entities = onSort(entityStream, roomSearchDto.getPageAndSort().getCname(), roomSearchDto.getPageAndSort().getIsSorted()).collect(Collectors.toList());
            // 저장 후 다시 스트림 변환, entityStream에 저장
            entityStream = entities.stream();
        }

        // 페이징 메서드 호출
        // 결과 값 : 프론트단에서 사용할 페이지 데이터 및 페이징 처리 된 데이터 리스트를 담은 해시 맵 객체
        Map<String,Object> resultMap = onPagging(roomSearchDto.getPageAndSort().getNowPage(), roomSearchDto.getPageAndSort().getLimitPage(), entities.size(), entityStream);
        // 페이징 처리 된 스트림 객체 entityStream에 저장
        entityStream = (Stream<RoomReservationEntity>) resultMap.get("paggingResult");
        // 저장된 스트림 리스트로 변환, entities에 다시 저장
        entities = entityStream.collect(Collectors.toList());

        // entity List<>를 dto로 변환 후 roomDtoList에 저장
        List<RoomReservationDto> roomDtoList = new ArrayList<>();
        for( RoomReservationEntity entity : entities ) roomDtoList.add(entity.toDto());
        // 맵에서 페이징 결과 스트림 remove 후 결과 값 들어있는 dto 삽입
        resultMap.remove("paggingResult"); resultMap.put( "roomDtoList", roomDtoList );
        // 페이지 데이터/검색,정렬 완료 된 데이터 담겨있는 HashMap 반환
        return resultMap;
    }// end
//----------------------------------------------------------------------------------------------------------------------//
    /*
    * 키워드의 타입 판별 메서드
    * */
    public String aboutType(String keyword){
        if(keyword.isEmpty()) return null;
        // 이름 판단
        if(!keyword.matches("^[0-9]*$")) return "mname";

        //  호실,전화번호 판단
        else if(  keyword.matches("\\d{0,5}")  ) return "rno";
        else return "rphone";
    }
    /*
    *   정렬 메서드
    * */
    public Stream<RoomReservationEntity> onSort( Stream<RoomReservationEntity> entityStream, String columnName, String issorted  ){
        // 정렬할 컬럼 명
        final String cname = columnName;
        // 정렬 기준
        final boolean isSorted = Boolean.parseBoolean(issorted);
        if( "rrno".equals(cname) )
            return entityStream.sorted( (a,b) -> isSorted ?
                            a.getRoomEntity().getRno() - b.getRoomEntity().getRno()
                            : b.getRoomEntity().getRno() - a.getRoomEntity().getRno() );

            // 객실 등급 정렬
        else if( "rgrade".equals(cname) )
            return entityStream.sorted(
                            (a,b) -> isSorted ? // compareTo 사용
                                    a.getRoomEntity().getRoomGradeEntity().getRgname()
                                            .compareTo(b.getRoomEntity().getRoomGradeEntity().getRgname() )
                                    : b.getRoomEntity().getRoomGradeEntity().getRgname()
                                    .compareTo(a.getRoomEntity().getRoomGradeEntity().getRgname()));

            // 시작 날짜 정렬
        else if( "sdate".equals(cname) ) // compareTo 사용
            return entityStream.sorted( (a,b) -> isSorted ?
                            a.getRrstartdate().compareTo(b.getRrenddate())
                            : b.getRrstartdate().compareTo( a.getRrstartdate() ));

            // 종료 날짜 정렬
        else if( "edate".equals(cname) ) // compareTo 사용
            return  entityStream.sorted( (a,b) -> isSorted ?
                            a.getRrenddate().compareTo(b.getRrenddate())
                            : b.getRrenddate().compareTo( a.getRrenddate() ));

            // 예약자 명 정렬
        else if( "rname".equals(cname) )
            return entityStream.sorted( (a,b) -> isSorted ?
                            a.getMemberInfoEntity().getMname().compareTo( b.getMemberInfoEntity().getMname())
                            : b.getMemberInfoEntity().getMname().compareTo( a.getMemberInfoEntity().getMname()));
            // 휴대번호 정렬
        else if( "rphone".equals(cname) )
            return entityStream.sorted( (a,b) -> isSorted ?
                            a.getMemberInfoEntity().getMphone().compareTo( b.getMemberInfoEntity().getMphone())
                            : b.getMemberInfoEntity().getMphone().compareTo( a.getMemberInfoEntity().getMphone()));
            // 체크인 정렬
        else if( "rcin".equals(cname) )
            return entityStream.sorted( isSorted ?
                    Comparator.comparing( RoomReservationEntity::getRrcheckin )
                    : Comparator.comparing( RoomReservationEntity::getRrcheckin ).reversed());
            // 체크아웃 정렬
        else if("rcout".equals(cname) )
            return entityStream.sorted( (a,b) -> {
                final LocalDateTime aTime = a.getRrcheckout();
                final LocalDateTime bTime = b.getRrcheckout();
                // 오름차순
                if(isSorted){
                    if( aTime == null && bTime != null ) return -1;
                    if( aTime != null && bTime == null ) return 1;
                    if( aTime == null && bTime == null ) return 0;
                    if( aTime != null && bTime != null ) return aTime.compareTo(bTime);
                }
                // 내림차순
                else {
                    if( aTime == null && bTime != null ) return 1;
                    if( aTime != null && bTime == null ) return -1;
                    if( aTime == null && bTime == null ) return 0;
                    if( aTime != null && bTime != null ) return bTime.compareTo(aTime);
                }
                return 0;
            });
        return null;
    }// onSort() end
    /*
     *   검색 메서드
     * */
    public Stream<RoomReservationEntity> onSearch(
            RoomSearchDto roomSearchDto , List<RoomReservationEntity> entities)
    {
        // String으로 받은 날짜를 LocalDate로 파싱
        LocalDate startdate = null, enddate = null;
        if( !roomSearchDto.getRrstartdate().isEmpty() )
            startdate = LocalDate.parse( roomSearchDto.getRrstartdate() , DateTimeFormatter.ISO_DATE );
        if( !roomSearchDto.getRrenddate().isEmpty() )
            enddate = LocalDate.parse( roomSearchDto.getRrenddate() , DateTimeFormatter.ISO_DATE );
        // 검색 시작 날짜
        final LocalDate finalStartDate = startdate;
        // 검색 끝 날짜
        final LocalDate finalEnddate = enddate;
        // 검색 키워드
        final String keyword = roomSearchDto.getKeyword();
        // 검색 타입( 전화번호/회원이름/호실 )
        final String type = aboutType(keyword);
        // 리스트 스트림 변환 후 저장
        Stream<RoomReservationEntity> entityStream = entities.stream();
        /*
         * 날짜 필터링
         *   1. 입력 날짜가 시작 날짜, 종료 날짜 둘 다 존재할 경우
         *   2. 입력 날짜만 존재할 경우
         *   3. 종료 날짜만 존재할 경우
         * 등급 필터링
         *   1. 등급이 선택되지 않은 경우
         *   2. 등급이 선택된 경우
         * 키워드 필터링
         *   1. 키워드 type이 어떤 것인지
         * 페이지 필터링
         * */
        // 시작 날짜, 종료 날짜 둘 다 null이 아니면 실행
        if( finalStartDate != null || finalEnddate != null ) {
            entities = entityStream
                    //날짜 필터
                    .filter(
                            entity ->
                                    finalStartDate != null && finalEnddate != null ?
                                            // 1. 입력받은 날짜가 엔티티 시작날짜 종료날짜 사이에 있다면 true
                                            (entity.getRrstartdate().isBefore(finalStartDate) && entity.getRrenddate().isAfter(finalEnddate)

                                                    ||

                                                    // 2.
                                                    // 입력받은 시작날짜가 엔티티 시작날짜와 종료날짜 사이에 있거나
                                                    // 입력받은 종료날짜가 엔티티 시작 날짜와 종료날짜 사이에 있다면 true
                                                    ((entity.getRrstartdate().isAfter(finalStartDate) && entity.getRrstartdate().isBefore(finalEnddate))
                                                            ||  (entity.getRrenddate().isAfter(finalStartDate) && entity.getRrenddate().isBefore(finalEnddate)))

                                                    ||

                                                    //3.
                                                    // 입력받은 시작날짜가 엔티티 날짜보다 크거나 같고, 종료날짜가 엔티티 날짜보다 작거나 같으면 true
                                                    ((entity.getRrstartdate().isEqual(finalStartDate) || entity.getRrstartdate().isAfter(finalStartDate))
                                                            && (entity.getRrenddate().isEqual(finalEnddate) || entity.getRrenddate().isBefore(finalEnddate))))

                                            // 입력받은 시작날짜가 엔티티 날짜와 같으면 true
                                            : finalStartDate != null ? entity.getRrstartdate().isEqual(finalStartDate)
                                            // 입력받은 종료날짜가 엔티티 날짜와 같으면 true
                                            : entity.getRrenddate().isEqual(finalEnddate)).collect(Collectors.toList());
            entityStream = entities.stream();
        }
        // 등급 필터 ( 선택 등급이 Nonselect가 아니라면 실행  )
        if( !"Nonselect".equals(roomSearchDto.getGname()) ) {
            entities = entityStream.filter(
                    entity ->
                            // 입력받은 등급이 엔티티 등급과 같으면
                            entity.getRoomEntity().getRoomGradeEntity().getRgname().equals(
                                    roomSearchDto.getGname())).collect(Collectors.toList());
            entityStream = entities.stream();
        }
        // 키워드 필터 ( 키워드 type이 null이 아니라면 실행 )
        if( type != null ) {
            entities = entityStream.filter(
                    entity -> {
                        // 타입이 방번호일 때 검색 키워드가 엔티티 방번호와 같다면 true
                        if ("rno".equals(type)) {
                            final int keywordEqualRno = Integer.parseInt(keyword);
                            return entity.getRoomEntity().getRno() == keywordEqualRno;
                            // 타입이 사용자 이름일 때 검색 키워드가 엔티티 사용자 이름과 같다면 true
                        } else if ("mname".equals(type)) return entity.getMemberInfoEntity().getMname().equals(keyword);
                            // 키워드가 엔티티 전화번호와 같다면 true
                        else return entity.getMemberInfoEntity().getMphone().equals(keyword);
                    }).collect(Collectors.toList());
            entityStream = entities.stream();
        }
        return entityStream;
    }// onSearch() end
    /*
    * 페이징 추상 메서드 구현
    * */
    @Override
    public Map<String,Object> onPagging( int page, int limitPage, int entitiesSize, Object recordList  ){
        Stream<RoomReservationEntity> entityStream = (Stream<RoomReservationEntity>) recordList;
        // 스킵할 행 개수
        final int startRow = (page-1) * limitPage;
        // 총페이지 수
        int totalPage = entitiesSize%limitPage == 0 ? entitiesSize/limitPage : entitiesSize/limitPage+1 ;
        int startBtn = ((page-1) / 5) * 5 + 1;
        int endBtn = startBtn + 4;
        // endBtn이 총 페이지 수보다 크거나 같으면 endBtn에 총 페이지 수 대입
        if( endBtn >= totalPage ) endBtn = totalPage;
        final int finalEndBtn = endBtn;

        // 결과 반환
        return new HashMap(){{
            put("totalSize",entitiesSize);put("totalPage", totalPage);
            put("startBtn", startBtn);put("endBtn",finalEndBtn);
            // 페이지에 따른 검색결과 축소 skip( startRow )만큼 skip하고 limit( limitPage ) 크기로 제한함
            put("paggingResult" , entityStream.skip( startRow ).limit( limitPage ));
        }};
    }

}




//임시저장
/*
        if( finalStartDate != null && finalEnddate != null )
                entityStream.filter( entitiy ->
                entitiy.getRrstartdate().isBefore( finalStartDate )
                && entitiy.getRrstartdate().isAfter( finalEnddate ));
                // 2. 요청값과 엔티티 시작날짜와 같을 경우
                else if( finalStartDate != null )
                entityStream.filter( entitiy -> entitiy.getRrstartdate().isEqual( finalStartDate ));
                // 3. 요청값과 엔티티 종료날짜와 같을 경우
                else if( finalEnddate != null)
                entityStream.filter( entitiy -> entitiy.getRrenddate().isEqual( finalEnddate ));
                // ------------------------------------------------------------
                // 등급 필터링 ------------------------------------------------
                String gname = roomSearchDto.getGname();
                // 등급이 NonSelect가 아니라면 필터링
                if( !"NonSelect".equals(gname) )
                entityStream.filter(
                entitiy -> entitiy.getRoomEntity().getRoomGradeEntity().getRgname().equals(gname));
                // -----------------------------------------------------------
                // 키워드 필터링 -------------------------------------------------
                if( type != null ){
                if( "rno".equals(type) ){
final int keywordEqualRno = Integer.parseInt(keyword);
        entityStream.filter( entity -> entity.getRrno() == keywordEqualRno );
        }
        else if( "mname".equals(type) )
        entityStream.filter( entity -> entity.getMemberInfoEntity().getMname().equals(keyword));
        else if( "rphone".equals(type) )
        entityStream.filter( entity -> entity.getMemberInfoEntity().getMphone().equals(keyword));
        }*/

        /*return AddPagging.builder()
                .startBtn(startBtn)
                .endBtn(endBtn)
                .totalSize(totalSize)
                .totalPage(totalPage)
                .roomDtoList(roomDtoList)
                .build();*/


// 정렬 기준에 따른 정렬 ----------------------------------------------------------

/*        // 정렬할 컬럼 명
        final String cname = roomSearchDto.getCname();
        // 정렬 기준
        final boolean isSorted = Boolean.parseBoolean(roomSearchDto.getIsSorted());*/
/*        // 호실 정렬
        if( "rrno".equals(cname) )
            entities = entityStream.sorted( (a,b) -> isSorted ?
                    a.getRoomEntity().getRno() - b.getRoomEntity().getRno()
                    : b.getRoomEntity().getRno() - a.getRoomEntity().getRno() )
                            .collect(Collectors.toList());
        // 객실 등급 정렬
        else if( "rgrade".equals(cname) )
            entities = entityStream.sorted(
                    (a,b) -> isSorted ? // compareTo 사용
                            a.getRoomEntity().getRoomGradeEntity().getRgname()
                                    .compareTo(b.getRoomEntity().getRoomGradeEntity().getRgname() )
                            : b.getRoomEntity().getRoomGradeEntity().getRgname()
                                    .compareTo(a.getRoomEntity().getRoomGradeEntity().getRgname()))
                                                .collect(Collectors.toList());
        // 시작 날짜 정렬
        else if( "sdate".equals(cname) ) // compareTo 사용
            entities = entityStream.sorted( (a,b) -> isSorted ?
                    a.getRrstartdate().compareTo(b.getRrenddate())
                            : b.getRrstartdate().compareTo( a.getRrstartdate() ))
                   .collect(Collectors.toList());
        // 종료 날짜 정렬
        else if( "edate".equals(cname) ) // compareTo 사용
            entities = entityStream.sorted( (a,b) -> isSorted ?
                    a.getRrenddate().compareTo(b.getRrenddate())
                    : b.getRrenddate().compareTo( a.getRrenddate() ))
                        .collect(Collectors.toList());
        // 예약자 명 정렬
        else if( "rname".equals(cname) )
            entities = entityStream.sorted( (a,b) -> isSorted ?
                    a.getMemberInfoEntity().getMname().compareTo( b.getMemberInfoEntity().getMname())
                    : b.getMemberInfoEntity().getMname().compareTo( a.getMemberInfoEntity().getMname()))
                            .collect(Collectors.toList());
        // 휴대번호 정렬
        else if( "rphone".equals(cname) )
            entities = entityStream.sorted( (a,b) -> isSorted ?
                            a.getMemberInfoEntity().getMphone().compareTo( b.getMemberInfoEntity().getMphone())
                            : b.getMemberInfoEntity().getMphone().compareTo( a.getMemberInfoEntity().getMphone()))
                    .collect(Collectors.toList());
        // 체크인 정렬
        else if( "rcin".equals(cname) )
            entities = entityStream.sorted( isSorted ?
                            Comparator.comparing( RoomReservationEntity::getRrcheckin )
                    : Comparator.comparing( RoomReservationEntity::getRrcheckin ).reversed()).collect(Collectors.toList());
        // 체크아웃 정렬
        else if("rcout".equals(cname) )
            entities = entityStream.sorted( (a,b) -> {
                // 양수면 a 음수면 b
                final LocalDateTime aTime = a.getRrcheckout();
                final LocalDateTime bTime = b.getRrcheckout();
                // 오름차순
                if(isSorted){
                    if( aTime == null && bTime != null ) return -1;
                    if( aTime != null && bTime == null ) return 1;
                    if( aTime == null && bTime == null ) return 0;
                    if( aTime != null && bTime != null ) return aTime.compareTo(bTime);
                }
                // 내림차순
                else {
                    if( aTime == null && bTime != null ) return 1;
                    if( aTime != null && bTime == null ) return -1;
                    if( aTime == null && bTime == null ) return 0;
                    if( aTime != null && bTime != null ) return bTime.compareTo(aTime);
                }
                return 0;
            }).collect(Collectors.toList());*/
/*
 * 날짜 필터링
 *   1. 입력 날짜가 시작 날짜, 종료 날짜 둘 다 존재할 경우
 *   2. 입력 날짜만 존재할 경우
 *   3. 종료 날짜만 존재할 경우
 * 등급 필터링
 *   1. 등급이 선택되지 않은 경우
 *   2. 등급이 선택된 경우
 * 키워드 필터링
 *   1. 키워드 type이 어떤 것인지
 * 페이지 필터링
 * */
// 시작 날짜, 종료 날짜 둘 다 null이 아니면 실행
        /*if( finalStartDate != null || finalEnddate != null ) {
            entities = entityStream
                    //날짜 필터
                    .filter(
                            entity ->
                                    finalStartDate != null && finalEnddate != null ?
                                            // 1. 입력받은 날짜가 엔티티 시작날짜 종료날짜 사이에 있다면 true
                                            (entity.getRrstartdate().isBefore(finalStartDate) && entity.getRrenddate().isAfter(finalEnddate)

                                            ||

                                            // 2.
                                            // 입력받은 시작날짜가 엔티티 시작날짜와 종료날짜 사이에 있거나
                                            // 입력받은 종료날짜가 엔티티 시작 날짜와 종료날짜 사이에 있다면 true
                                            ((entity.getRrstartdate().isAfter(finalStartDate) && entity.getRrstartdate().isBefore(finalEnddate))
                                                    ||  (entity.getRrenddate().isAfter(finalStartDate) && entity.getRrenddate().isBefore(finalEnddate)))

                                            ||

                                            //3.
                                                    // 입력받은 시작날짜가 엔티티 날짜보다 크거나 같고, 종료날짜가 엔티티 날짜보다 작거나 같으면 true
                                            ((entity.getRrstartdate().isEqual(finalStartDate) || entity.getRrstartdate().isAfter(finalStartDate))
                                                    && (entity.getRrenddate().isEqual(finalEnddate) || entity.getRrenddate().isBefore(finalEnddate))))

                                            // 입력받은 시작날짜가 엔티티 날짜와 같으면 true
                                           : finalStartDate != null ? entity.getRrstartdate().isEqual(finalStartDate)
                                            // 입력받은 종료날짜가 엔티티 날짜와 같으면 true
                                            : entity.getRrenddate().isEqual(finalEnddate)).collect(Collectors.toList());
            entityStream = entities.stream();
        }
        // 등급 필터 ( 선택 등급이 Nonselect가 아니라면 실행  )
        if( !"Nonselect".equals(roomSearchDto.getGname()) ) {
            entities = entityStream.filter(
                    entity ->
                            // 입력받은 등급이 엔티티 등급과 같으면
                            entity.getRoomEntity().getRoomGradeEntity().getRgname().equals(
                                    roomSearchDto.getGname())).collect(Collectors.toList());
            entityStream = entities.stream();
        }
        // 키워드 필터 ( 키워드 type이 null이 아니라면 실행 )
        if( type != null ) {
            entities = entityStream.filter(
                    entity -> {
                        // 타입이 방번호일 때 검색 키워드가 엔티티 방번호와 같다면 true
                        if ("rno".equals(type)) {
                            final int keywordEqualRno = Integer.parseInt(keyword);
                            return entity.getRoomEntity().getRno() == keywordEqualRno;
                            // 타입이 사용자 이름일 때 검색 키워드가 엔티티 사용자 이름과 같다면 true
                        } else if ("mname".equals(type)) return entity.getMemberInfoEntity().getMname().equals(keyword);
                        // 키워드가 엔티티 전화번호와 같다면 true
                        else return entity.getMemberInfoEntity().getMphone().equals(keyword);
                    }).collect(Collectors.toList());
            entityStream = entities.stream();
        }*/