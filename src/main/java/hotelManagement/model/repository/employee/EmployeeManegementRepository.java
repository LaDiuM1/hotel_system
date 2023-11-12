package hotelManagement.model.repository.employee;

import hotelManagement.model.entity.employee.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeManegementRepository extends JpaRepository<EmployeeEntity, String> {
}
