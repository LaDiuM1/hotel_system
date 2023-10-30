package hotelManagement.model.repository;

import hotelManagement.model.entity.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestEntityRepository extends JpaRepository<GuestEntity, Integer> {


}
