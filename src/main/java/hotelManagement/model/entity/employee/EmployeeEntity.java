package hotelManagement.model.entity.employee;

import hotelManagement.model.entity.BaseTime;
import hotelManagement.model.entity.member.MemberInfoEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table( name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
// 직원 엔티티
public class EmployeeEntity extends BaseTime {
    @Id
    @Column( length = 8,nullable = false)
    private String eno;     // 사번
    @Column(length = 100, nullable = false)
    private String epwd;    // 비밀번호
    @Column(length = 50)
    private String address; // 주소
    @Column(columnDefinition = "tinyint", nullable = false)
    private int erank;      // 접근권한

    @OneToOne
    @JoinColumn(name = "mno")
    private MemberInfoEntity memberInfoEntity; // 멤버 공통 엔티티

    @ManyToOne
    @JoinColumn(name="pname")
    private PositionEntity positionEntity;  // 직책 엔티티

    @ManyToOne
    @JoinColumn(name="dcode")
    private DepartmentEntity departmentEntity; // 부서코드 엔티티
}
