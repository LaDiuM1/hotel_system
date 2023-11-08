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
    private LocalDate startDate;// 검색 시작 날짜
    private LocalDate endDate;  // 검색 끝 날짜
    private String keyword;     // 검색 키워드
    private int nowPage;        // 현재 페이지
    private int limitPage;      // 제한 페이지
}
