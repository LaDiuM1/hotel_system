package hotelManagement.service.business.staticsService;

import hotelManagement.model.dto.business.OperationStatisticsDto;
import hotelManagement.model.repository.business.statistics.TotalUserStatisticsRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TotalUserStatisticsService {
    @Autowired
    private TotalUserStatisticsRepositiory totalUserStatisticsRepositiory;
    /*
    * 통계 가져오기
    * */
    public List<Map<String,Object>> reportStatistics(OperationStatisticsDto operationStatisticsDto ){

        final String category = operationStatisticsDto.getDateCategory();
        // 카테고리가 년 별
        if( "year".equals(category) )
            return yearTotal();
            // 카테고리가 월 별
        else if( "month".equals(category))
            return monthTotal(operationStatisticsDto.getDivisionMonth());
            // 카테고리가 주간 별
        else if( "week".equals(category) )
            return weekTotal( operationStatisticsDto.getDivisionMonth(), operationStatisticsDto.getDivisionWeek() );

        else
            // 결과 없음
            return new ArrayList<>();
    }
    /*
    * 카테고리에 따른 통계
    * */
    public List<Map<String,Object>> yearTotal(){

        List<Object[]> yearLocationTotalSales = totalUserStatisticsRepositiory.yearLocationTotal();
        List<Object[]> yearRoomReservationTotalSales = totalUserStatisticsRepositiory.yearLocationTotal();
        List<Object[]> yearTicketTotalSales = totalUserStatisticsRepositiory.yearLocationTotal();

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
                put( "x", String.valueOf((int)objects[0])); put("y", objects[1]);
            }});

        maps = ((ArrayList<Map<String,Object>>)roomresvMap.get("data"));
        for( Object[] objects : yearRoomReservationTotalSales )
            maps.add( new HashMap<String,Object>(){{
                put( "x",String.valueOf((int)objects[0])); put("y", objects[1]);
            }});

        maps = ((ArrayList<Map<String,Object>>)ticketMap.get("data"));
        for( Object[] objects : yearTicketTotalSales )
            maps.add( new HashMap<String,Object>(){{
                put( "x", String.valueOf((int)objects[0])); put("y", objects[1]);
            }});


        return Arrays.asList( locationMap, roomresvMap, ticketMap );
    }
    /*
     * 카테고리에 따른 통계
     * */
    public List<Map<String,Object>> monthTotal( String year ){

        List<Object[]> monthLocationTotalSales = totalUserStatisticsRepositiory.monthLocationTotal(year);
        List<Object[]> monthRoomReservationTotalSales = totalUserStatisticsRepositiory.monthRoomTotal(year);
        List<Object[]> monthTicketTotalSales = totalUserStatisticsRepositiory.monthLocationTotal(year);

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
                put( "x", String.valueOf((int)objects[0])); put("y", objects[1]);
            }});

        maps = ((ArrayList<Map<String,Object>>)roomresvMap.get("data"));
        for( Object[] objects : monthRoomReservationTotalSales )
            maps.add( new HashMap<String,Object>(){{
                put( "x",String.valueOf((int)objects[0])); put("y", objects[1]);
            }});

        maps = ((ArrayList<Map<String,Object>>)ticketMap.get("data"));
        for( Object[] objects : monthTicketTotalSales )
            maps.add( new HashMap<String,Object>(){{
                put( "x", String.valueOf((int)objects[0])); put("y", objects[1]);
            }});


        return Arrays.asList( locationMap, roomresvMap, ticketMap );
    }
    /*
    * 주간 통계
    * */
    public List<Map<String,Object>> weekTotal( String year, String month ){
        List<Object[]> weekLocationTotalSales = totalUserStatisticsRepositiory.weekLocationTotal(year,month);
        List<Object[]> weekRoomReservationTotalSales = totalUserStatisticsRepositiory.weekRoomReservationTotal(year,month);
        List<Object[]> weekTicketTotalSales = totalUserStatisticsRepositiory.weekTicketTotal(year,month);

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
                put( "x", String.valueOf((int)objects[0])); put("y", objects[1]);
            }});

        maps = ((ArrayList<Map<String,Object>>)roomresvMap.get("data"));
        for( Object[] objects : weekRoomReservationTotalSales )
            maps.add( new HashMap<String,Object>(){{
                put( "x",String.valueOf((int)objects[0])); put("y", objects[1]);
            }});

        maps = ((ArrayList<Map<String,Object>>)ticketMap.get("data"));
        for( Object[] objects : weekTicketTotalSales )
            maps.add( new HashMap<String,Object>(){{
                put( "x", String.valueOf((int)objects[0])); put("y", objects[1]);
            }});


        return Arrays.asList( locationMap, roomresvMap, ticketMap );
    }
}
