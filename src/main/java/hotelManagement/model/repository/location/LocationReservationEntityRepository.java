package hotelManagement.model.repository.location;

import hotelManagement.model.entity.locationEntity.LocationReservationEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface LocationReservationEntityRepository extends JpaRepository<LocationReservationEntity,Integer> {
    // 시설명, 상태, 시작날짜, 종료날짜
    @Query( value = " select l.lrstate,l.lrtime,l.lname,m.mname,m.mphone from lresv l, memberinfo m where l.mno = m.mno " +
            // lname이 Nonselect라면 조건X , wholeDining이라면 전체 다이닝 예약 get, 둘 다 해당되지 않는다면 lname = :lname
            " AND IF( :lname = 'Nonselect' , true, IF( :lname = 'wholeDining', lname like '___다이닝', l.lname = :lname ) ) " +
            // lrstate 0 예약 중, 1 예약 만료, 2 예약 취소, 3 모든 예약 상태 만약 lrstate가 3이라면 조건X
            " AND IF( :lrstate = 3, true, l.lrstate = :lrstate ) " +
            // 검색 시작 시간과 종료 시간 둘 다 존재 시 lrtime,endDate 사이 레코드 조회/ 시작 시간만 입력 시 lrtime과 일치하는 레코드 조회
            " AND IF( :lrtime = '', true, " +
                    "IF( :endDate = '', date_format(lrtime, '%Y-%m-%d') = :lrtime, date_format(lrtime, '%Y-%m-%d') between :lrtime and :endDate)) " +
            // 검색 키워드에 따른 전화번호 또는 이름 조회
            " AND IF( :keyword = '', true, m.mname like %:keyword% or m.mphone like %:keyword% ) " , nativeQuery = true )
    List<Map<String,Object>> findByLocationReservation(String lname, int lrstate, String lrtime, String endDate, String keyword ) ;





}
