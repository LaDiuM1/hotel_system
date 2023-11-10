package hotelManagement.model.repository.employee;

import hotelManagement.model.entity.employee.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionEntityRepository extends JpaRepository<PositionEntity, String> {

}
