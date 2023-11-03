package hotelManagement.model.dto.member;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
// 방 검색 시 사용하는 Dto
public class RoomSearchDto {
    private String gname;
    private String rrstartdate;
    private String rrenddate;
    private String keyword;
}
