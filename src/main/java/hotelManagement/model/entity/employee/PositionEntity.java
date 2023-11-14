package hotelManagement.model.entity.employee;

import hotelManagement.model.dto.employee.PositionDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "position")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PositionEntity {

    @Id
    @Column(length = 10,nullable = false)
    private String pname;   // 직책 이름
    @Column(nullable = false)
    @ColumnDefault("0")
    private int psalary;    // 직책별 월급
    @Column(nullable = false)
    private float pbonus;   // 직책별 성과급 비율
    @Column(columnDefinition = "tinyint", nullable = false)
    private int pannual;    // 직책별 기본 연차 수

    @ToString.Exclude
    @OneToMany( mappedBy = "departmentEntity" )
    @Builder.Default
    private List<EmployeeEntity> employeeEntityList = new ArrayList<>(); // 직원 연관 관계 리스트

    // Entity -> Dto
    public PositionDto toDto(){
        return PositionDto.builder()
                .pname(this.pname)
                .psalary(this.psalary)
                .pbonus(this.pbonus)
                .pannual(this.pannual)
                .build();
    }

}
