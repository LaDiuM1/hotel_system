package hotelManagement.model.dto.employee;

import hotelManagement.model.entity.employee.DepartmentEntity;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder    // 부서 정보 DTO
public class DepartmentDto {

    private String dcode;   // 부서 코드 번호 [ 2자리 ]
    private String dname;   // 부서명

    private List<EmployeeDto> employeeDtoList; // 직원 연관 관계 리스트

    // Dto -> Entity
    public DepartmentEntity toEntity(){
        return DepartmentEntity.builder()
                .dcode(this.dcode)
                .dname(this.dname)
                .build();
    }
}
