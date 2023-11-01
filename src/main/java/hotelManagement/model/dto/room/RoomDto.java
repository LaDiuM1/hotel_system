package hotelManagement.model.dto.room;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString @Builder

// 객실 DTO
public class RoomDto {

    private int rno;                    // 호실 번호 [ pk ]
    private boolean rstate;              // 객실 상태
    private String rgname;              // 객실 등급명 테이블 fk

}
