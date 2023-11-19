package hotelManagement.model.repository.business.statistics;

import hotelManagement.service.util.StatisticsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@Repository
public class TotalUserStatisticsRepositiory implements StatisticsQuery {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Object[]> yearLocationTotal() {
        Query q = entityManager.createNativeQuery("select year(l.cdate), count(l.lrno) " +
                "from lresv l " +
                "    group by year(l.cdate) " +
                "    order by year(l.cdate)");
        List<Object[]> results = q.getResultList();
        return results;
    }
    @Override
    public List<Object[]> yearRoomReservationTotal() {
        Query q = entityManager.createNativeQuery("select year(rv.rrtime), count(rrno) " +
                "from roomresv rv " +
                "    group by year(rv.rrtime) " +
                "    order by year(rv.rrtime) asc");
        List<Object[]> results = q.getResultList();
        return results;
    }
    @Override
    public List<Object[]> yearTicketTotal() {
        Query q = entityManager.createNativeQuery("select year(t.cdate), count(tno) " +
                "from ticket t " +
                "    group by year(t.cdate) " +
                "    order by year(t.cdate)");
        List<Object[]> results = q.getResultList();
        return results;
    }

    @Override
    public List<Object[]> monthLocationTotal(String year) {
        Query q = entityManager.createNativeQuery("select month(l.cdate), count(l.lrno) " +
                "from lresv l " +
                "    where year(l.cdate) = :year " +
                "    group by month(l.cdate) " +
                "    order by month(l.cdate) asc ")
                .setParameter("year",year);
        List<Object[]> results = q.getResultList();
        return results;
    }

    @Override
    public List<Object[]> monthRoomTotal(String year) {
        Query q = entityManager.createNativeQuery("select month(rv.rrtime) , count(rv.rrno) " +
                "from roomresv rv " +
                "    where year(rv.rrtime) = :year " +
                "group by month(rv.rrtime) " +
                "    order by month(rv.rrtime) asc  ")
                .setParameter("year", year);
        List<Object[]> results = q.getResultList();
        return results;
    }

    @Override
    public List<Object[]> monthTicketTotal(String year) {
        Query q = entityManager.createNativeQuery("select month(t.cdate), count(tno) " +
                "from ticket t " +
                "where year(t.cdate) = :year " +
                "group by month(t.cdate) " +
                "order by month(t.cdate) asc")
                .setParameter("year",year);
        List<Object[]> results = q.getResultList();
        return results;
    }

    @Override
    public List<Object[]> weekLocationTotal(String year, String month) {
        Query q = entityManager.createNativeQuery("select week(l.cdate, 1) - week( date_format(l.cdate, '%Y-%m-01' ),1)+1 " +
                        ", count( l.lrno ) " +
                        "from lresv l " +
                        "where date_format(l.cdate, '%Y-%m') = :year '-' :month " +
                        "group by( week(l.cdate, 1) - week( date_format(l.cdate, '%Y-%m-01' ),1)+1) " +
                        "order by week(l.cdate, 1) - week( date_format(l.cdate, '%Y-%m-01' ),1)+1 asc")
                        .setParameter("year",year ).setParameter("month", month);
        List<Object[]> results = q.getResultList();
        return results;
    }

    @Override
    public List<Object[]> weekRoomReservationTotal(String year, String month) {
        Query q = entityManager.createNativeQuery("select week(rv.rrtime, 1) - week( date_format(rv.rrtime, '%Y-%m-01' ),1)+1  " +
                ", count( rv.rrno)" +
                "from roomresv rv " +
                "where date_format(rv.rrtime, '%Y-%m') = :year '-' :month " +
                "group by( week(rv.rrtime, 1) - week( date_format(rv.rrtime, '%Y-%m-01' ),1)+1) " +
                "order by week(rv.rrtime, 1) - week( date_format(rv.rrtime, '%Y-%m-01' ),1)+1 asc ")
                .setParameter("year",year).setParameter("month",month);
        List<Object[]> results = q.getResultList();
        return results;
    }

    @Override
    public List<Object[]> weekTicketTotal(String year, String month) {
        Query q = entityManager.createNativeQuery("select ( week(t.cdate, 1) - week( date_format(t.cdate, '%Y-%m-01' ),1)+1)  " +
                ", count(tno)" +
                "from ticket t " +
                "where date_format(t.cdate, '%Y-%m') = :year '-' :month " +
                "group by ( week(t.cdate, 1) - week( date_format(t.cdate, '%Y-%m-01' ),1)+1) " +
                "order by ( week(t.cdate, 1) - week( date_format(t.cdate, '%Y-%m-01' ),1)+1) asc ")
                .setParameter("year",year).setParameter("month",month);
        List<Object[]> results = q.getResultList();
        return results;
    }
}
