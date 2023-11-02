package hotelManagement.model.repository.guestroom;

import hotelManagement.model.entity.guestroom.RoomReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface RoomReservationEntityRepository extends JpaRepository<RoomReservationEntity, Integer> {
    //boolean existsByRnoAndRrcheckinGreaterThanAndRrcheckoutLessThan(int rno, LocalDateTime date1, LocalDateTime date2);

    // ---------------- //
    // 1. get All

    // 2. 날짜 조건

    // 3. 등급, 날짜 조건

    // 4. 등급, 날짜 키워드 조건

    // ---------------- //

}
