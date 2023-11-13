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
    private String depart;      // 부서
    private String position;    // 직책
    private String keyword;     // 검색 키워드
    private String searchType;  // 검색 타입(사번,사원명,사원 전화번호)
    // 정렬과 페이징 위한 객체
    private PageAndSort pageAndSort;
}
