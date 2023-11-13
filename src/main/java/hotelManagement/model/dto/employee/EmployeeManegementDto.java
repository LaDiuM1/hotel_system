package hotelManagement.model.dto.employee;

import hotelManagement.model.dto.forPageAndSort.PageAndSort;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class EmployeeManegementDto {

    private PageAndSort pageAndSort; // 정렬과 페이징 위한 객체
}
