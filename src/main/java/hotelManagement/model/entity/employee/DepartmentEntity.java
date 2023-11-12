package hotelManagement.model.entity.employee;

import hotelManagement.model.entity.BaseTime;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "department")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
// 부서 엔티티
public class DepartmentEntity extends BaseTime {
    @Id
    @Column(length = 2)
    private String dcode; // 부서코드 pk
    @Column(length = 15)
    private String dname;   // 부서명

    @ToString.Exclude
    @OneToMany(mappedBy = "departmentEntity")
    @Builder.Default
    List<EmployeeEntity> employeeEntities = new ArrayList<>();  // 직원 엔티티 리스트 (양방향 관계)

}
