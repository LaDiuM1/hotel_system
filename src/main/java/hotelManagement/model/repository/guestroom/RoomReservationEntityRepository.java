package hotelManagement.model.repository.guestroom;

import hotelManagement.model.entity.guestroom.RoomReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RoomReservationEntityRepository extends JpaRepository<RoomReservationEntity, Integer> {
    boolean existsByRnoAndRrstartdateGreaterThanAndRrenddateLessThan(int rno, LocalDate date1, LocalDate date2);

}
