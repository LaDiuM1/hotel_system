package hotelManagement.model.repository.guestroom;

import hotelManagement.model.entity.guestroom.RoomGradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomGradeEntityRepository extends JpaRepository<RoomGradeEntity, String> {


}
