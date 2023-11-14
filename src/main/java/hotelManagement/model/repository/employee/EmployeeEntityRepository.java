package hotelManagement.model.repository.employee;

import hotelManagement.model.entity.employee.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, String> {

    @Query( value =
            "select count(dcode_fk)+1 from employee\n" +
            "where dcode_fk = :dcode_fk\n" +
            "and year(ejoin) = :joinYear"
            , nativeQuery = true )
    int record(@Param(value="dcode_fk") String dcode, @Param(value="joinYear") String joinYear);

}
