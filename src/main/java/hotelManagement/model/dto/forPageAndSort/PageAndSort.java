package hotelManagement.model.dto.forPageAndSort;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
// 페이지와 정렬에 관련한 필드 선언
public class PageAndSort {
    private int nowPage;        // 현재 페이지
    private int limitPage;      // 제한 페이지
    private String cname;       // 정렬 할 컬럼 이름
    private String isSorted;   // 정렬 기준
}
