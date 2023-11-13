package hotelManagement.model.dto.department;

import hotelManagement.model.dto.member.MemberInfoDto;
import hotelManagement.model.entity.employee.EmployeeEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder    // 직원 정보 DTO
public class EmployeeDto {

    private String eno;         // 직원 사번 8자리 숫자 코드 [ 연도 2자리 + 부서 2자리 + 순서 레코드 번호 ]
    private String epwd;        // 직원 비밀번호
    private String eaddress;    // 직원 집주소

    private DepartmentDto departmentDto;  // 부서 참조 연관 관계 필드

    private MemberInfoDto memberInfoDto;  // 직원 정보 테이블 참조 연관 관계 필드

    private PositionDto positionDto;  // 직책 참조 연관 관계 필드

    // dto -> entity
    public EmployeeEntity toEntity(){
        return EmployeeEntity.builder()
                .eno(this.eno)
                .eaddress(this.eaddress)
                .build();
    }


}
