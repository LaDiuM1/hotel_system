package hotelManagement.model.repository.room;

import hotelManagement.model.entity.room.RoomReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface RoomReservationEntityRepository extends JpaRepository<RoomReservationEntity, Integer> {
    @Query( value =
            "select * from roomresv\n" +
            "where rrcheckin <= :date and (:date <= rrcheckout or rrcheckout is null)\n" +
            "and rno_fk = :rno"
            , nativeQuery = true )
    RoomReservationDto stateCheck(@Param(value="rno") int rno, @Param(value="date") LocalDateTime date);

     interface RoomReservationDto {
        int getRrno();
        LocalDateTime getRrtime();       // 객실 예약 시간 필드
        LocalDate getRrstartdate();      // 예약 시작 날짜
        LocalDate getRrenddate();        // 예약 종료 날짜
        LocalDateTime getRrcheckin();    // 체크인 시간
        LocalDateTime getRrcheckout();   // 체크아웃 시간

         int getMno_fk();
     }

    // ---------------- //
    // 1. get All

    // 2. 날짜 조건

    // 3. 등급, 날짜 조건

    // 4. 등급, 날짜 키워드 조건

    // ---------------- //

}
