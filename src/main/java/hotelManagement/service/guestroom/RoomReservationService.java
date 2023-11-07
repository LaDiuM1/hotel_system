package hotelManagement.service.guestroom;

import hotelManagement.model.dto.room.RoomReservationDto;
import hotelManagement.model.dto.room.RoomSearchDto;
import hotelManagement.model.entity.room.RoomReservationEntity;
import hotelManagement.model.repository.room.RoomReservationEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RoomReservationService {

    @Autowired
    RoomReservationEntityRepository roomReservationEntityRepository;
    // get 객실 예약 리스트
    public Map<String,Object> getRoomReservation(RoomSearchDto roomSearchDto){


        // String으로 받은 날짜를 LocalDate로 파싱
        LocalDate startdate = null, enddate = null;
        if( !roomSearchDto.getRrstartdate().isEmpty() )
            startdate = LocalDate.parse( roomSearchDto.getRrstartdate() , DateTimeFormatter.ISO_DATE );
        if( !roomSearchDto.getRrenddate().isEmpty() )
            enddate = LocalDate.parse( roomSearchDto.getRrenddate() , DateTimeFormatter.ISO_DATE );
        // forEach 사용 시 상수여야 함.
        // 그러므로 LocalDate로 파싱한 변수들을 상수에 담음.
        final LocalDate finalStartDate = startdate;
        final LocalDate finalEnddate = enddate;
        /*
        *  keyword의 전화번호, 이름, 호실 판단 로직
        *   type엔 keyword가 이름, 호실, 전화번호, 공백 중 하나가 들어있음
        * */
        final String keyword = roomSearchDto.getKeyword();
        final String type = aboutType(keyword);

        // 모든 예약 정보 호출 -------------------------------------------------------------
        List<RoomReservationEntity> entities= roomReservationEntityRepository.findAll();
        // 예약정보 스트림 생성
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

        // ------- 페이징 ----------- //
        int page = roomSearchDto.getNowPage();
        final int startRow = (page-1) * 10;
        // 엔티티 총 사이즈
        int totalSize = entities.size();
        int totalPage = totalSize%10 == 0 ? totalSize/10 : totalSize/10+1 ;
        int startBtn = ((page-1) / 5) * 5 + 1;
        int endBtn = startBtn + 4;
        // endBtn이 총 페이지 수보다 크거나 같으면 endBtn에 총 페이지 수 대입
        if( endBtn >= totalPage ) endBtn = totalPage;
        final int finalEndBtn = endBtn;
        // 페이지에 따른 검색결과 축소 시작 행(startRow)만큼 skip하고 limit(10) 크기로 제한함
        entities = entityStream.skip( startRow ).limit(10).collect(Collectors.toList());
        // ------------------ //
        // dto 변환
        List<RoomReservationDto> roomDtoList = new ArrayList<>();
        for( RoomReservationEntity entity : entities ) roomDtoList.add(entity.toDto());
        // HashMap 반환 ( 페이징에 필요한 필드와 더불어 내부에 roomDtoList 필드 존재 )
        return new HashMap(){{
            put("totalSize",totalSize);put("totalPage", totalPage);
            put("startBtn", startBtn);put("endBtn",finalEndBtn);
            put("roomDtoList",roomDtoList);
        }};
    }
    // 키워드의 타입 판별 메서드
    public String aboutType(String keyword){
        if(keyword.isEmpty()) return null;
        // 이름 판단
        if(!keyword.matches("^[0-9]*$")) return "mname";

        //  호실,전화번호 판단
        else if(  keyword.matches("\\d{0,5}")  ) return "rno";
        else return "rphone";
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