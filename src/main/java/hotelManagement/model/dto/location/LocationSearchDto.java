package hotelManagement.model.dto.location;

import hotelManagement.model.dto.forPageAndSort.PageAndSort;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class LocationSearchDto {
    private String lname;       // 시설 명
    private int lrstate;        // 예약 상태 0 예약 중, 1 예약 만료, 2 예약 취소
    private String startDate;// 검색 시작 날짜
    private String endDate;  // 검색 끝 날짜
    private String keyword;     // 검색 키워드
    // 페이징 처리와 정렬에 관련한 필드 선언되어있음
    private PageAndSort pageAndSort;
}
