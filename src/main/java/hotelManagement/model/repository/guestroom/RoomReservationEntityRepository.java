package hotelManagement.model.repository.guestroom;

import hotelManagement.model.entity.guestroom.RoomReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface RoomReservationEntityRepository extends JpaRepository<RoomReservationEntity, Integer> {
    boolean existsByRnoAndRrcheckinGreaterThanAndRrcheckoutLessThan(int rno, LocalDateTime date1, LocalDateTime date2);

}
