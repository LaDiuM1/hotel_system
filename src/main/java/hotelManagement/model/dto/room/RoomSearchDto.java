package hotelManagement.model.dto.room;

import lombok.*;

import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
// 방 검색 시 사용하는 Dto
public class RoomSearchDto {
    private String gname;       // 등급 명
    private String rrstartdate; // 시작 날짜
    private String rrenddate;   // 종료 날짜
    private String keyword;     // 키워드
    private int nowPage;        // 현재 페이지
    private int limitPage;      // 제한 페이지
    private String cname;       // 정렬 할 컬럼 이름
    private String isSorted;   // 정렬 기준
}
