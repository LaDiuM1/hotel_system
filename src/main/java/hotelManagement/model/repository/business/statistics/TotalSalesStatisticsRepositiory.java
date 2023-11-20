package hotelManagement.model.repository.business.statistics;

import hotelManagement.service.util.StatisticsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TotalSalesStatisticsRepositiory implements StatisticsQuery {

    @Autowired
    private EntityManager entityManager;
    /*
    * 년 별 총 매출
    * */
    // 시설
    public List<Object[]> yearLocationTotal(){
        Query q = entityManager.createNativeQuery(" select " +
                "   year(l.cdate) as '년',   " +
                "    sum(round(           " +
                "         (case        " +
                "            when left(m.mbirth, 4) > year(now())-6 " +
                "            then lo.lchildprice" +
                "                else lo.lprice end) " +
                "                * (if( l.lrtime between t.tstartdate and t.tenddate, d.drate, 1 ))" +
                "                )) as '총 매출'" +
                "        from lresv l " +
                "         inner join location lo on l.lname = lo.lname " +
                "         inner join ticket t on l.mno = t.mno " +
                "         inner join discount d on lo.lname = d.dtype" +
                "         inner join memberinfo m on l.mno = m.mno" +
                "         group by year(l.cdate) order by year(l.cdate) asc  ");
        List<Object[]> results = q.getResultList();
        return results;
    }
    // 객실
    public List<Object[]> yearRoomReservationTotal(){
        Query q = entityManager.createNativeQuery("select year(rv.rrtime) as '년' ," +
                "   sum( round(" +
                "      (case" +
                "         when weekday(rv.rrtime) = 5 or weekday(rv.rrtime) = 6 " +
                "            then g.rwprice" +
                "            else g.rhprice end)" +
                "            *" +
                "            ( if( rv.rrtime between t.tstartdate and t.tenddate, d.drate, 1 ))" +
                "            )) as '총 매출'" +
                "   from roomresv rv" +
                "      inner join room r on rv.rno_fk = r.rno" +
                "        inner join discount d on d.dtype = r.rgname_fk" +
                "        inner join rgrade g on g.rgname = r.rgname_fk" +
                "        inner join ticket t on rv.mno_fk = t.mno" +
                "        group by year(rv.rrtime) " +
                "       order by year(rv.rrtime) asc ");
        List<Object[]> results = q.getResultList();
        return results;
    }
    // 회원권
    public List<Object[]> yearTicketTotal(){
        Query q = entityManager.createNativeQuery( "select year(t.cdate) as '년', sum(100000) as '총 매출' " +
                "from ticket t " +
                "group by year(t.cdate) " +
                "order by year(t.cdate) asc ");
        List<Object[]> results = q.getResultList();
        return results;
    }
    /*
    * 월 별 총 매출
    * */
    // 시설
    public List<Object[]> monthLocationTotal( String year ){
        Query q = entityManager.createNativeQuery("select month(l.cdate), " +
                "sum(round(           " +
                "         (case         " +
                "            when left(m.mbirth, 4) > year(now())-6 " +
                "            then lo.lchildprice " +
                "                else lo.lprice end) " +
                "                * (if( l.mno = t.mno, if( l.lrtime between t.tstartdate and t.tenddate, d.drate, 1 ), 1 ) " +
                "            ))) as '총 매출' " +
                "from lresv l " +
                "inner join location lo on l.lname = lo.lname " +
                "inner join ticket t on l.mno = t.mno " +
                "inner join discount d on lo.lname = d.dtype " +
                "inner join memberinfo m on l.mno = m.mno " +
                "where year(l.cdate) = :year " +
                "group by month(l.cdate) " +
                "order by month(l.cdate) asc ").setParameter("year", year);
        List<Object[]> results = q.getResultList();
        return results;
    }
    // 객실
    public List<Object[]> monthRoomTotal( String year ){
        Query q = entityManager.createNativeQuery(" select month(rv.rrtime) as '월' , " +
                "sum( round( " +
                "  (case " +
                " when weekday(rv.rrtime) = 5 or weekday(rv.rrtime) = 6 " +
                "then rwprice " +
                "else rhprice end) " +
                "*" +
                "( if( rv.rrtime between t.tstartdate and t.tenddate, d.drate, 1 )) " +
                ")) as '총 매출' " +
                "from roomresv rv  " +
                "inner join room r on rv.rno_fk = r.rno " +
                "inner join discount d on d.dtype = r.rgname_fk " +
                "inner join rgrade g on g.rgname = r.rgname_fk " +
                "inner join ticket t on rv.mno_fk = t.mno " +
                "where year(rv.rrtime) = :year " +
                "group by month(rv.rrtime) " +
                "order by month(rv.rrtime) asc ").setParameter("year", year);
        List<Object[]> results = q.getResultList();
        return results;
    }
    // 회원권
    public List<Object[]> monthTicketTotal( String year ){
        Query q = entityManager.createNativeQuery("select month(cdate) as '월', " +
                "sum(100000) as '총 매출' " +
                "from ticket t " +
                "where year(t.cdate) = :year " +
                "group by month(cdate) " +
                "order by month(cdate) asc ").setParameter("year",year);
        List<Object[]> results = q.getResultList();
        return results;
    }
    /*
    *  주간 별
    * */
    // 시설
    public List<Object[]> weekLocationTotal( String year, String month ){
        Query q = entityManager.createNativeQuery("select  " +
                        "week(l.cdate, 1) - week( date_format(l.cdate, '%Y-%m-01' ),1)+1 , " +
                        "    sum(round(           " +
                        "         (case         " +
                        "            when left(m.mbirth, 4) > year(now())-6 " +
                        "            then lo.lchildprice" +
                        "                else lo.lprice end) " +
                        "                * (if( l.mno = t.mno, if( l.lrtime between t.tstartdate and t.tenddate, d.drate, 1 ), 1 ) " +
                        "            ))) as '총 매출' " +
                        "from lresv l " +
                        "inner join location lo on l.lname = lo.lname " +
                        " inner join ticket t on l.mno = t.mno " +
                        " inner join discount d on lo.lname = d.dtype " +
                        " inner join memberinfo m on l.mno = m.mno " +
                        "where date_format(l.cdate, '%Y-%m') = :year '-' :month " +
                        "group by( week(l.cdate, 1) - week( date_format(l.cdate, '%Y-%m-01' ),1)+1) ")
                         .setParameter("year",year ).setParameter("month", month);
        List<Object[]> results = q.getResultList();
        // native query로 order by가 불가능해 stream sort 사용
        return results.stream().sorted( (o1, o2) -> (int)o1[0] - (int)o2[0] ).collect(Collectors.toList());
    }
    // 객실
    public List<Object[]> weekRoomReservationTotal(String year, String month){
        Query q = entityManager.createNativeQuery("select  " +
                "week(rv.rrtime, 1) - week( date_format(rv.rrtime, '%Y-%m-01' ),1)+1 as '주차' , " +
                "    sum( round(" +
                "      (case" +
                "         when weekday(rv.rrtime) = 5 or weekday(rv.rrtime) = 6 " +
                "            then rwprice " +
                "            else rhprice end) " +
                "            *" +
                "            ( if( rv.rrtime between t.tstartdate and t.tenddate, d.drate, 1 )) " +
                "            )) as '총 매출' " +
                "from roomresv rv " +
                "inner join room r on rv.rno_fk = r.rno " +
                "inner join discount d on d.dtype = r.rgname_fk " +
                "inner join rgrade g on g.rgname = r.rgname_fk " +
                "inner join ticket t on rv.mno_fk = t.mno " +
                "where date_format(rv.rrtime, '%Y-%m') = :year '-' :month " +
                "group by( week(rv.rrtime, 1) - week( date_format(rv.rrtime, '%Y-%m-01' ), 1 )+1) ")
                .setParameter("year",year).setParameter("month",month);
        List<Object[]> results = q.getResultList();
        // native query로 order by가 불가능해 stream sort 사용
        return results.stream().sorted( (o1, o2) -> (int)o1[0] - (int)o2[0] ).collect(Collectors.toList());
    }
    // 할인권
    public List<Object[]> weekTicketTotal(String year, String month){
        Query q = entityManager.createNativeQuery("select " +
                "week(t.cdate, 1) - week( date_format(t.cdate, '%Y-%m-01' ),1)+1 as '주차', " +
                "sum(100000) as '총 매출' " +
                "from ticket t " +
                "where date_format(t.cdate, '%Y-%m') = :year '-' :month " +
                "group by( week(t.cdate, 1) - week( date_format(t.cdate, '%Y-%m-01' ), 1 )+1) " +
                "order by week(t.cdate, 1) - week( date_format(t.cdate, '%Y-%m-01' ),1)+1")
                .setParameter("year",year).setParameter("month",month);
        List<Object[]> results = q.getResultList();
        return results;
    }
}
