package hotelManagement.model.repository.room;

import hotelManagement.model.entity.room.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomEntityRepository extends JpaRepository<RoomEntity, Integer> {


}
