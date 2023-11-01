package hotelManagement.model.repository.room;

import hotelManagement.model.entity.room.RoomGradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomGradeEntityRepository extends JpaRepository<RoomGradeEntity, String> {


}
