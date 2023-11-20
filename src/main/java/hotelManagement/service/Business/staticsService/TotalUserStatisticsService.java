package hotelManagement.service.business.staticsService;

import hotelManagement.model.dto.business.OperationStatisticsDto;
import hotelManagement.model.repository.business.statistics.TotalUserStatisticsRepositiory;
import hotelManagement.service.util.ReportStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TotalUserStatisticsService implements ReportStatistics {
    @Autowired
    private TotalUserStatisticsRepositiory totalUserStatisticsRepositiory;
    /*
    * 통계 가져오기
    * */
    @Override
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
    @Override
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
    @SuppressWarnings("unchecked")
    @Override
    public List<Map<String,Object>> monthTotal( String year ){

        List<Object[]> monthLocationTotalUser = totalUserStatisticsRepositiory.monthLocationTotal(year);
        List<Object[]> monthRoomReservationTotalUser = totalUserStatisticsRepositiory.monthRoomTotal(year);
        List<Object[]> monthTicketTotalUser = totalUserStatisticsRepositiory.monthLocationTotal(year);

        // 1월부터 12월까지 0으로 초기화 하기 위한 리스트
        List<Map<String,Object>> hasMonth = new ArrayList<>();
        // 1월부터 12월까지 hasMonth에 넣는 for문 각 개월은 0으로 초기화
        for( int i = 1; i <= 12; i++ ){
            HashMap<String, Object> map = new HashMap<>();
            map.put( "x", i +"월"); map.put( "y" , 0);
            hasMonth.add( map );
        }

        Map<String,Object> locationMap = new HashMap<String,Object>(){{
            put("id","시설"); put("color","hsl(286, 70%, 50%)" );
            put("data", new ArrayList<Map<String,Object>>(hasMonth) );
        }};
        Map<String,Object> roomresvMap = new HashMap<String,Object>(){{
            put("id","객실"); put("color","hsl(339, 70%, 50%)" );
            put("data", new ArrayList<Map<String,Object>>(hasMonth) );
        }};
        Map<String,Object> ticketMap = new HashMap<String,Object>(){{
            put("id","회원권"); put("color","hsl(52, 70%, 50%)" );
            put("data", new ArrayList<Map<String,Object>>(hasMonth) );
        }};

        ArrayList<Map<String,Object>> maps;

        maps = ((ArrayList<Map<String,Object>>)locationMap.get("data"));
        for( Object[] objects : monthLocationTotalUser ){
            int month = (int)objects[0] - 1;
            if( maps.get( month ).containsValue(0) ){
                maps.get( month ).put("y",objects[1]);
            }
        }

        maps = ((ArrayList<Map<String,Object>>)roomresvMap.get("data"));
        for( Object[] objects : monthRoomReservationTotalUser ){
            int month = (int)objects[0]-1;
            if( maps.get( month ).containsValue(0) ){
                maps.get( month ).put("y",objects[1]);
            }
        }

        maps = ((ArrayList<Map<String,Object>>)ticketMap.get("data"));
        for( Object[] objects : monthTicketTotalUser ){
            int month = (int)objects[0]-1;
            if( maps.get( month ).containsValue(0) ){
                maps.get( month ).put("y",objects[1]);
            }
        }


        return Arrays.asList( locationMap, roomresvMap, ticketMap );
    }
    /*
    * 주간 통계
    * */
    @Override
    public List<Map<String,Object>> weekTotal( String year, String month ){
        List<Object[]> weekLocationTotalUser = totalUserStatisticsRepositiory.weekLocationTotal(year,month);
        List<Object[]> weekRoomReservationTotalUser = totalUserStatisticsRepositiory.weekRoomReservationTotal(year,month);
        List<Object[]> weekTicketTotalUser = totalUserStatisticsRepositiory.weekTicketTotal(year,month);

        // 1주차부터 6주차까지 0으로 초기화 하기 위한 리스트
        List<Map<String,Object>> hasWeek = new ArrayList<>();
        // 1주차부터 6주차까지 hasWeek 넣는 for문 각 개월은 0으로 초기화
        for( int i = 1; i <= 6; i++ ){
            HashMap<String, Object> map = new HashMap<>();
            map.put( "x", i +"주차"); map.put( "y" , 0);
            hasWeek.add( map );
        }

        Map<String,Object> locationMap = new HashMap<String,Object>(){{
            put("id","시설"); put("color","hsl(286, 70%, 50%)" );
            put("data", new ArrayList<Map<String,Object>>(hasWeek) );
        }};
        Map<String,Object> roomresvMap = new HashMap<String,Object>(){{
            put("id","객실"); put("color","hsl(339, 70%, 50%)" );
            put("data", new ArrayList<Map<String,Object>>(hasWeek) );
        }};
        Map<String,Object> ticketMap = new HashMap<String,Object>(){{
            put("id","회원권"); put("color","hsl(52, 70%, 50%)" );
            put("data", new ArrayList<Map<String,Object>>(hasWeek) );
        }};

        ArrayList<Map<String,Object>> maps;

        maps = ((ArrayList<Map<String,Object>>)locationMap.get("data"));
        for( Object[] objects : weekLocationTotalUser ){
            int week = (int)objects[0]-1;
            if( maps.get( week ).containsValue(0) ){
                maps.get( week ).put("y",objects[1]);
            }
        }

        maps = ((ArrayList<Map<String,Object>>)roomresvMap.get("data"));
        for( Object[] objects : weekRoomReservationTotalUser ){
            int week = (int)objects[0]-1;
            if( maps.get( week ).containsValue(0) ){
                maps.get( week ).put("y",objects[1]);
            }
        }

        maps = ((ArrayList<Map<String,Object>>)ticketMap.get("data"));
        for( Object[] objects : weekTicketTotalUser ){
            int week = (int)objects[0]-1;
            if( maps.get( week ).containsValue(0) ){
                maps.get( week ).put("y",objects[1]);
            }
        }


        return Arrays.asList( locationMap, roomresvMap, ticketMap );
    }
}
