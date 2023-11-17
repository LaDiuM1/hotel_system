package hotelManagement.model.dto.business;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OperationStatisticsDto {

    private String wholeCategory;   // 전체 카테고리(매출,이용자수,지출)
    private String dateCategory;    // 날짜 카테고리(년,월,주간)
    private String divisionMonth;   // 년도(월 별 구분 시 사용)
    private String divisionWeek;    // 개월(주간 별 구분 시 사용)

}
