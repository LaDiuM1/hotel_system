package hotelManagement.model.entity.employee;

import hotelManagement.model.dto.department.DepartmentDto;
import lombok.*;

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
public class DepartmentEntity {

    @Id
    @Column(length = 2)
    private String dcode;      // 부서 코드 번호 [ 2자리 ]
    @Column(unique = true, length = 15, nullable = false)
    private String dname;   // 부서명

    @ToString.Exclude
    @OneToMany( mappedBy = "departmentEntity" )
    @Builder.Default
    private List<EmployeeEntity> employeeEntityList = new ArrayList<>(); // 직원 연관 관계 리스트

    // Entity -> Dto
    public DepartmentDto toDto(){
        return DepartmentDto.builder()
                .dcode(this.dcode)
                .dname(this.dname)
                .build();
    }
}
