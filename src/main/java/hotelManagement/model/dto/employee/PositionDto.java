package hotelManagement.model.dto.employee;

import hotelManagement.model.dto.employee.EmployeeDto;
import hotelManagement.model.entity.employee.PositionEntity;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder    // 직책 정보 DTO
public class PositionDto {

    private String pname;   // 직책 이름
    private int psalary;    // 직책별 월급
    private float pbonus;   // 직책별 성과급 비율
    private int pannual;    // 직책별 기본 연차 수

    private List<EmployeeDto> employeeDtoList; // 직원 연관 관계 리스트

    // Dto -> Entity
    public PositionEntity toEntity(){
        return PositionEntity.builder()
                .pname(this.pname)
                .psalary(this.psalary)
                .pbonus(this.pbonus)
                .pannual(this.pannual)
                .build();

    }

}
