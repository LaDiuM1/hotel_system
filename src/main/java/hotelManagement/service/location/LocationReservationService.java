package hotelManagement.service.location;


import hotelManagement.model.dto.location.LocationSearchDto;
import hotelManagement.model.repository.location.LocationReservationEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LocationReservationService {

    @Autowired
    LocationReservationEntityRepository locationReservationEntityRepository;

    public Map<String,Object> getLocationReservation(LocationSearchDto locationSearchDto){

        // 검색 조건에 따른 예약 정보 Map객체 하나당 레코드 한개
        List<Map<String,Object>> totalList = locationReservationEntityRepository.findByLocationReservation(
                locationSearchDto.getLname(), locationSearchDto.getLrstate()
                , locationSearchDto.getStartDate(), locationSearchDto.getEndDate()
                , locationSearchDto.getKeyword()  );

        // 페이징 처리 후 반환
        return purposePagging(locationSearchDto.getPageAndSort().getNowPage(), locationSearchDto.getPageAndSort().getLimitPage(), totalList.size() , totalList);
    }

    // 페이징 처리 위한 메서드
    public HashMap<String,Object> purposePagging( int page, int limitPage, int totalSize, List<Map<String,Object>> totalList ){
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
}

