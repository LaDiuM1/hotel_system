package hotelManagement.service.util;

import java.util.List;

public interface StatisticsQuery {
    /*
    * 년 별
    * */
    // 시설
    public abstract List<Object[]> yearLocationTotal();
    // 객실
    public abstract List<Object[]> yearRoomReservationTotal();
    // 회원권
    public abstract List<Object[]> yearTicketTotal();
    /*
     * 월 별
     * */
    // 시설
    public abstract List<Object[]> monthLocationTotal( String year );
    // 객실
    public abstract List<Object[]> monthRoomTotal( String year );
    // 회원권
    public abstract List<Object[]> monthTicketTotal( String year );
    /*
    * 주간 별
    * */
    // 시설
    public abstract List<Object[]> weekLocationTotal( String year, String month );
    // 객실
    public abstract List<Object[]> weekRoomReservationTotal(String year, String month);
    // 할인권
    public abstract List<Object[]> weekTicketTotal(String year, String month);
}
