package hotelManagement.model.entity.employee;

import hotelManagement.model.dto.department.EmployeeDto;
import hotelManagement.model.entity.member.MemberInfoEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder    // 직원 엔티티
public class EmployeeEntity {

    @Id
    @Column(length = 8)
    private String eno;         // 직원 사번 8자리 숫자 코드 [ 연도 2자리 + 부서 2자리 + 순서 레코드 번호 ]
    @Column(length = 100, nullable = false)
    private String epwd;        // 직원 비밀번호
    @Column(length = 50)
    private String eaddress;    // 직원 집주소
    @Column(columnDefinition = "tinyint", nullable = false)
    private int erank;          // 접근 권한 등급

    @ManyToOne
    @JoinColumn(name = "dcode_fk")
    private DepartmentEntity departmentEntity;  // 부서 참조 연관 관계 필드

    @OneToOne
    @JoinColumn( name = "mno_fk")
    private MemberInfoEntity memberInfoEntity;  // 직원 정보 테이블 참조 연관 관계 필드

    @ManyToOne
    @JoinColumn( name = "pname_fk")
    private PositionEntity positionEntity;  // 직책 참조 연관 관계 필드

    // Entity -> Dto
    public EmployeeDto toDto(){
        return EmployeeDto.builder()
                .eno(this.eno)
                .eaddress(this.eaddress)
                .erank(this.erank)
                .build();

    }

}
