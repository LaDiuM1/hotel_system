package hotelManagement.model.repository.employee;

import hotelManagement.model.entity.employee.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentEntityRepository extends JpaRepository<DepartmentEntity, String> {

}
