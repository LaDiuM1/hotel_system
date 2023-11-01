package hotelManagement.model.dto.room;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
// 객실 등급 DTO
public class RoomGradeDto {

    private String rgname;          // 객실 등급명 [ pk ]
    private int rwprice;            // 평일 객실 이용료
    private int rhprice;            // 주말 객실 이용료
    private int rgmaxcapa;          // 객실 최대 수용 인원
}
