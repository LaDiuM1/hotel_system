package hotelManagement.model.dto.location;

import lombok.*;

import java.time.LocalDate;
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
    // 페이징에 필요한 필드
    private int nowPage;        // 현재 페이지
    private int limitPage;      // 제한 페이지
    // 정렬에 필요한 필드
    private String cname;       // 컬럼명
    private String isSorted;   // 정렬 기준
}
