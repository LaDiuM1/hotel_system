package hotelManagement.service.Business;

import hotelManagement.model.dto.business.OperationStatisticsDto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class OperationStatisticsService {


    // wholeCategory=sales, dateCategory=year, divisionMonth=2023, divisionWeek=10
    public List<Map<String,Object>> getStatistics( OperationStatisticsDto operationStatisticsDto ){

        return null;
    }
    // 카테고리 나누기
    // 매출
    public List<Map<String,Object>> totalSales(){
        // 객실 예약, 시설 예약, 회원권 구매
        // 객실 예약은 회원권 영향받음

        // 1. 년별
        //      모든 연도에 해당하는 총 매출



        // 2. 월별
        //      divisionMonth의 년도에 해당하는 1~12월까지 각 월 별 총 매출

        // 3. 주간
        //      divisionMonth와 divisionWeek에 해당하는 년도, 개월의 주간 별 총 매출

        return null;
    }
    // 이용자 수
    public List<Map<String,Object>> totalUser(){

        return null;
    }
    // 지출
    public List<Map<String,Object>> totalExpenditure(){

        return null;
    }

    // 1. 년별
    //      모든 연도에 해당하는 총 매출, 총 이용자, 총 지출

    // 2. 월별
    //      divisionMonth의 년도에 해당하는 1~12월까지 각 월 별 총 매출, 총 이용자, 총 지출

    // 3. 주간
    //      divisionMonth와 divisionWeek에 해당하는 년도, 개월의 주간 별 총 매출, 총 이용자, 총 지출



}
