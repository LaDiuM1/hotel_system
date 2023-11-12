package hotelManagement.model.entity.employee;

import hotelManagement.model.entity.BaseTime;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "position")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
// 직책 엔티티
public class PositionEntity extends BaseTime {
    @Id
    @Column(length = 10,nullable = false)
    private String pname;   // 직책명 pk
    private int psalary;    // 월급
    private float pbonus;    // 성과급
    @Column(columnDefinition = "tinyint")
    private int pannual;    // 연차

    @OneToMany(mappedBy = "positionEntity")
    @ToString.Exclude
    @Builder.Default
    List<EmployeeEntity> employeeEntities = new ArrayList<>();    // 직원 엔티티 리스트 (양방향 관계)
}
