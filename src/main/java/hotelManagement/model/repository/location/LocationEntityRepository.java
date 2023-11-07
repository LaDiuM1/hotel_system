package hotelManagement.model.repository.location;

import hotelManagement.model.entity.locationEntity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationEntityRepository extends JpaRepository<LocationEntity,String> {
}
