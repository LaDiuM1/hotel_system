package hotelManagement.model.repository.location;

import hotelManagement.model.entity.locationEntity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationEntityRepository extends JpaRepository<LocationEntity,String> {
}
