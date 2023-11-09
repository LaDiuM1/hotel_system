package hotelManagement.model.repository.location;

import hotelManagement.model.dto.location.LocationReservationDto;
import hotelManagement.model.dto.location.LocationSearchDto;
import hotelManagement.model.entity.locationEntity.LocationReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface LocationReservationEntityRepository extends JpaRepository<LocationReservationEntity,Integer> {
    // 시설명, 상태, 시작날짜, 종료날짜
    @Query( value = " select l.lrstate,l.lrtime,l.lname,m.mname,m.mphone from lresv l, memberinfo m where l.mno = m.mno " +
            // lname이 Nonselect라면 조건X , wholeDining이라면 전체 다이닝 예약 get, 둘 다 해당되지 않는다면 lname = :lname
            " AND IF( :lname = 'Nonselect' , true, IF( :lname = 'wholeDining', lname like '___다이닝', l.lname = :lname ) ) " +
            // lrstate 0 예약 중, 1 예약 만료, 2 예약 취소, 3 모든 예약 상태 만약 lrstate가 3이라면 조건X
            " AND IF( :lrstate = 3, true, l.lrstate = :lrstate ) " +
            " AND IF( :lrtime = '', true, " +
                    "IF( :endDate = '', date_format(lrtime, '%Y-%m-%d') = :lrtime, date_format(lrtime, '%Y-%m-%d') between :lrtime and :endDate)) " +
            " AND IF( :keyword = '', true, (m.mname like %:keyword% or m.mphone like %:keyword%)) " +
            " IF( :cname = '', true, true ) ", nativeQuery = true )
    List<Map<String,Object>> findByLocationReservation( String lname, int lrstate, String lrtime, String endDate, String keyword, String cname );




}
