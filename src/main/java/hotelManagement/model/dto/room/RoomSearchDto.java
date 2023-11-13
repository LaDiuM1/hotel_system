package hotelManagement.model.dto.room;

import hotelManagement.model.dto.forPageAndSort.PageAndSort;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
// 방 검색 시 사용하는 Dto
public class RoomSearchDto  {
    private String gname;       // 등급 명
    private String rrstartdate; // 시작 날짜
    private String rrenddate;   // 종료 날짜
    private String keyword;     // 키워드
    // 페이징 처리와 정렬에 관련한 필드 선언되어있음
    PageAndSort pageAndSort;
}
