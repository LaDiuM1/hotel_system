package hotelManagement.service.location;


import hotelManagement.model.dto.location.LocationSearchDto;
import hotelManagement.model.repository.location.LocationReservationEntityRepository;
import hotelManagement.service.util.TotalList;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
// 제네릭 타입 T,G 는 각각 시설 검색 Dto, List<Map<String,Object>>
public class LocationReservationService implements TotalList<LocationSearchDto , List<Map<String,Object>> > {

    @Autowired
    LocationReservationEntityRepository locationReservationEntityRepository;
    /*
    *  시설 예약 리스트 getList 추상 메서드 구현
    * */
    @Override
    public Map<String,Object> getList(LocationSearchDto locationSearchDto){

        // 검색 조건에 따른 예약 정보 Map객체 하나당 레코드 한개
        List<Map<String,Object>> totalList = locationReservationEntityRepository.findByLocationReservation(
                locationSearchDto.getLname(), locationSearchDto.getLrstate()
                , locationSearchDto.getStartDate(), locationSearchDto.getEndDate()
                , locationSearchDto.getKeyword()  );

        // 컬럼명, 정렬 기준에 따른 정렬
        List<Map<String,Object>> results = onSort( totalList, locationSearchDto.getPageAndSort().getCname(), locationSearchDto.getPageAndSort().getIsSorted() );

        // 페이징 처리 후 반환
        return onPagging( results, locationSearchDto.getPageAndSort().getNowPage(), locationSearchDto.getPageAndSort().getLimitPage(), totalList.size() );
    }

    /*
    *   페이징 추상 메서드 구현
    * */
    @Override
    public Map<String,Object> onPagging( List<Map<String,Object>> totalList, int page, int limitPage, int totalSize  ){
        // 스킵할 행 개수
        final int startRow = (page-1) * limitPage;
        // 검색 결과에 따른 총 페이지 수
        final int totalPage = totalSize%limitPage == 0 ? totalSize/limitPage : totalSize/limitPage+1 ;
        // 시작 버튼 정보
        final int startBtn = ((page-1) / 5) * 5 + 1;
        // 종료 버튼 정보
        int endBtn = startBtn + 4;
        // endBtn이 총 페이지 수보다 크거나 같으면 endBtn에 총 페이지 수 대입
        if( endBtn >= totalPage ) endBtn = totalPage;
        // 종료 버튼 상수로 재선언
        final int finalEndBtn = endBtn;

        return new HashMap<String,Object>(){{
            // 페이지에 따른 검색결과 축소 skip( startRow )만큼 skip하고 limit( limitPage ) 크기로 제한함
            put( "locationReservationList", totalList.stream().skip(startRow).limit(limitPage).collect(Collectors.toList()) );
            put("totalSize",totalSize);put("totalPage", totalPage);
            put("startBtn", startBtn);put("endBtn",finalEndBtn);
        }};
    }
    /*
    *   정렬 추상 메서드 구현
    * */
    @Override
    public List<Map<String,Object>> onSort( List<Map<String,Object>> totalList, String columnName, String ascOrDesc ){
        // 정렬 요청 없을 시 리스트 반환
        if (columnName.isEmpty()) return totalList;
        // 정렬 기준(내림차순,오름차순)
        final boolean finalAscOrDesc = Boolean.parseBoolean(ascOrDesc);
        // totalList 스트림
        final Stream<Map<String, Object>> mapStream = totalList.stream();

        try {
            // 시설명 or 예약자명 or 예약자전화번호 정렬
            if ("lname".equals(columnName) || "mname".equals(columnName) || "mphone".equals(columnName))
                return mapStream.sorted((a, b) -> finalAscOrDesc ?
                                ((String) a.get(columnName)).compareTo((String) b.get(columnName))
                                : ((String) b.get(columnName)).compareTo((String) a.get(columnName))
                        ).collect(Collectors.toList());
                // 시설 예약 상태 정렬
            else if ("lrstate".equals(columnName))
                return mapStream.sorted((a, b) -> finalAscOrDesc ?
                                ((Byte) a.get(columnName)) - ((Byte) b.get(columnName))
                                : ((Byte) b.get(columnName)) - ((Byte) a.get(columnName))
                        ).collect(Collectors.toList());
                // 시설예약시간 정렬
            else if ("lrtime".equals(columnName))
                return mapStream.sorted((a, b) -> finalAscOrDesc ?
                                ((Timestamp) a.get(columnName)).compareTo((Timestamp) b.get(columnName))
                                : ((Timestamp) b.get(columnName)).compareTo((Timestamp) a.get(columnName))
                        ).collect(Collectors.toList());
        }catch (Exception e){
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
        // 빈 배열 반환(예외 발생)
        return new ArrayList<>();
    }
}

