package hotelManagement.model.repository.guestroom;

import hotelManagement.model.entity.guestroom.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomEntityRepository extends JpaRepository<RoomEntity, Integer> {


}
