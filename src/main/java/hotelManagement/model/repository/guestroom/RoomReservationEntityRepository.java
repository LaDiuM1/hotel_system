package hotelManagement.model.repository.guestroom;

import hotelManagement.model.entity.guestroom.RoomReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface RoomReservationEntityRepository extends JpaRepository<RoomReservationEntity, Integer> {
    @Query( value =
            "select rno_fk from roomresv\n" +
            "where rrcheckin <= :date and (:date <= rrcheckout or rrcheckout is null)\n" +
            "and rno_fk = :rno"
            , nativeQuery = true )
    Object stateCheck(@Param(value="rno") int rno, @Param(value="date") LocalDateTime date);

    // ---------------- //
    // 1. get All

    // 2. 날짜 조건

    // 3. 등급, 날짜 조건

    // 4. 등급, 날짜 키워드 조건

    // ---------------- //

}
