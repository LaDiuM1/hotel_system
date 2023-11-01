package hotelManagement.model.repository.room;

import hotelManagement.model.entity.room.RoomReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomReservationEntityRepository extends JpaRepository<RoomReservationEntity, Integer> {


}
