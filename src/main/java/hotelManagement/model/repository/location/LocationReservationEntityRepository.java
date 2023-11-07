package hotelManagement.model.repository.location;

import hotelManagement.model.entity.locationEntity.LocationReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationReservationEntityRepository extends JpaRepository<LocationReservationEntity,Integer> {
}
