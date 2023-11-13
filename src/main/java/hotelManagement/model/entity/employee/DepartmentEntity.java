package hotelManagement.model.entity.employee;

import hotelManagement.model.dto.department.DepartmentDto;
import lombok.*;
import hotelManagement.model.entity.BaseTime;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder    // 부서 엔티티
@EntityListeners(AuditingEntityListener.class)
public class DepartmentEntity extends BaseTime{

    @Id
    @Column(length = 2)
    private String dcode;      // 부서 코드 번호 [ 2자리 ]
    @Column(unique = true, length = 15, nullable = false)
    private String dname;   // 부서명

    @ToString.Exclude
    @OneToMany( mappedBy = "departmentEntity" )
    @Builder.Default
    private List<EmployeeEntity> employeeEntityList = new ArrayList<>(); // 직원 엔티티 리스트 (양방향 관계)

    // Entity -> Dto
    public DepartmentDto toDto(){
        return DepartmentDto.builder()
                .dcode(this.dcode)
                .dname(this.dname)
                .build();
    }
}
