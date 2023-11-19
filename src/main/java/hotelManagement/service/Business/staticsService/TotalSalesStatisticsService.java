package hotelManagement.service.Business.staticsService;

import hotelManagement.model.dto.business.OperationStatisticsDto;
import hotelManagement.model.repository.business.statistics.TotalSalesStatisticsRepositiory;
import hotelManagement.service.util.ReportStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class TotalSalesStatisticsService implements ReportStatistics {

    @Autowired
    private TotalSalesStatisticsRepositiory totalSalesStatisticsRepositiory;

    /*
    *  통계 가져오기
    * */
    @Override
    public List<Map<String,Object>> reportStatistics( OperationStatisticsDto operationStatisticsDto ){

        final String category = operationStatisticsDto.getDateCategory();
        // 카테고리가 년 별
        if( "year".equals(category) )
            return yearTotal();
        // 카테고리가 월 별
        else if( "month".equals(category))
            return monthTotal( operationStatisticsDto.getDivisionMonth() );
        // 카테고리가 주간 별
        else if( "week".equals(category) )
            return weekTotal( operationStatisticsDto.getDivisionMonth(), operationStatisticsDto.getDivisionWeek() );

        // 결과 없음
        return new ArrayList<>();
    }
    /*
    *   년 별 총 매출
    * */
    @Override
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> yearTotal(){

        // 1. 년별
        //      모든 연도에 해당하는 총 매출
        List<Object[]> yearLocationTotalSales = totalSalesStatisticsRepositiory.yearLocationTotal();
        List<Object[]> yearRoomReservationTotalSales = totalSalesStatisticsRepositiory.yearRoomReservationTotal();
        List<Object[]> yearTicketTotalSales = totalSalesStatisticsRepositiory.yearTicketTotal();

        Map<String,Object> locationMap = new HashMap<String,Object>(){{
           put("id","시설"); put("color","hsl(286, 70%, 50%)" );
           put("data", new ArrayList<Map<String,Object>>() );
        }};
        Map<String,Object> roomresvMap = new HashMap<String,Object>(){{
            put("id","객실"); put("color","hsl(339, 70%, 50%)" );
            put("data", new ArrayList<Map<String,Object>>() );
        }};
        Map<String,Object> ticketMap = new HashMap<String,Object>(){{
            put("id","회원권"); put("color","hsl(52, 70%, 50%)" );
            put("data", new ArrayList<Map<String,Object>>() );
        }};

        ArrayList<Map<String,Object>> maps;

        maps = ((ArrayList<Map<String,Object>>)locationMap.get("data"));
        for( Object[] objects : yearLocationTotalSales )
            maps.add( new HashMap<String,Object>(){{
                put( "x", String.valueOf((int)objects[0])); put("y", (int)(double)objects[1]);
            }});

        maps = ((ArrayList<Map<String,Object>>)roomresvMap.get("data"));
        for( Object[] objects : yearRoomReservationTotalSales )
            maps.add( new HashMap<String,Object>(){{
                    put( "x",String.valueOf((int)objects[0])); put("y", (int)(double)objects[1]);
            }});

        maps = ((ArrayList<Map<String,Object>>)ticketMap.get("data"));
        for( Object[] objects : yearTicketTotalSales )
            maps.add( new HashMap<String,Object>(){{
                put( "x", String.valueOf((int)objects[0])); put("y", ((BigDecimal)objects[1]).intValue() );
            }});

        return Arrays.asList( locationMap,ticketMap );
    }
    /*
    *   월 별 총 매출
    * */
    @Override
    public List<Map<String,Object>> monthTotal( String year ){

        List<Object[]> monthLocationTotalSales = totalSalesStatisticsRepositiory.monthLocationTotal( year );
        List<Object[]> monthRoomReservationTotalSales = totalSalesStatisticsRepositiory.monthRoomTotal( year );
        List<Object[]> monthTicketTotalSales = totalSalesStatisticsRepositiory.monthTicketTotal( year );

        Map<String,Object> locationMap = new HashMap<String,Object>(){{
            put("id","시설"); put("color","hsl(286, 70%, 50%)" );
            put("data", new ArrayList<Map<String,Object>>() );
        }};
        Map<String,Object> roomresvMap = new HashMap<String,Object>(){{
            put("id","객실"); put("color","hsl(339, 70%, 50%)" );
            put("data", new ArrayList<Map<String,Object>>() );
        }};
        Map<String,Object> ticketMap = new HashMap<String,Object>(){{
            put("id","회원권"); put("color","hsl(52, 70%, 50%)" );
            put("data", new ArrayList<Map<String,Object>>() );
        }};

        ArrayList<Map<String,Object>> maps;

        maps = ((ArrayList<Map<String,Object>>)locationMap.get("data"));
        for( Object[] objects : monthLocationTotalSales )
            maps.add( new HashMap<String,Object>(){{
                put( "x", String.valueOf((int)objects[0]) + "월"); put("y", (int)(double)objects[1]);
            }});

        maps = ((ArrayList<Map<String,Object>>)roomresvMap.get("data"));
        for( Object[] objects : monthRoomReservationTotalSales )
            maps.add( new HashMap<String,Object>(){{
                put( "x",String.valueOf((int)objects[0]) + "월"); put("y", (int)(double)objects[1]);
            }});

        maps = ((ArrayList<Map<String,Object>>)ticketMap.get("data"));
        for( Object[] objects : monthTicketTotalSales )
            maps.add( new HashMap<String,Object>(){{
                put( "x", String.valueOf((int)objects[0]) + "월"); put("y", ((BigDecimal)objects[1]).intValue() );
            }});

        return Arrays.asList( locationMap, roomresvMap, ticketMap );
    }
    /*
    * 주간 별 총 매출
    * */
    @Override
    public List<Map<String,Object>> weekTotal( String year, String month ){

        List<Object[]> weekLocationTotalSales = totalSalesStatisticsRepositiory.weekLocationTotal( year,month );
        List<Object[]> weekRoomReservationTotalSales = totalSalesStatisticsRepositiory.weekRoomReservationTotal( year,month );
        List<Object[]> weekTicketTotalSales = totalSalesStatisticsRepositiory.weekTicketTotal( year,month );

        Map<String,Object> locationMap = new HashMap<String,Object>(){{
            put("id","시설"); put("color","hsl(286, 70%, 50%)" );
            put("data", new ArrayList<Map<String,Object>>() );
        }};
        Map<String,Object> roomresvMap = new HashMap<String,Object>(){{
            put("id","객실"); put("color","hsl(339, 70%, 50%)" );
            put("data", new ArrayList<Map<String,Object>>() );
        }};
        Map<String,Object> ticketMap = new HashMap<String,Object>(){{
            put("id","회원권"); put("color","hsl(52, 70%, 50%)" );
            put("data", new ArrayList<Map<String,Object>>() );
        }};

        ArrayList<Map<String,Object>> maps;

        maps = ((ArrayList<Map<String,Object>>)locationMap.get("data"));
        for( Object[] objects : weekLocationTotalSales )
            maps.add( new HashMap<String,Object>(){{
                put( "x", String.valueOf((int)objects[0])); put("y", (double)objects[1]);
            }});

        maps = ((ArrayList<Map<String,Object>>)roomresvMap.get("data"));
        for( Object[] objects : weekRoomReservationTotalSales )
            maps.add( new HashMap<String,Object>(){{
                put( "x",String.valueOf((int)objects[0])); put("y", (int)(double)objects[1]);
            }});

        maps = ((ArrayList<Map<String,Object>>)ticketMap.get("data"));
        for( Object[] objects : weekTicketTotalSales )
            maps.add( new HashMap<String,Object>(){{
                put( "x", String.valueOf((int)objects[0])); put("y", ((BigDecimal)objects[1]).intValue() );
            }});
        // 임시적으로 locationMap 반환 안함
        return Arrays.asList(  roomresvMap, ticketMap );
    }
}
