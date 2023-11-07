package hotelManagement.model.dto.room;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString @Builder

// 객실 DTO
public class RoomDto {

    private int rno;                    // 호실 번호 [ pk ]
    private int rstate;              // 객실 상태
    private String rgname;              // 객실 등급명 테이블 fk
    @Builder.Default
    private List<RoomReservationDto> RoomReservationDtoList = new ArrayList<>();

}
