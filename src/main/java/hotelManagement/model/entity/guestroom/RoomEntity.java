package hotelManagement.model.entity.guestroom;

import hotelManagement.model.dto.guestroom.RoomDto;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "room")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class RoomEntity {

    @Id
    private int rno;                    // 호실 번호 [ pk ]
    @Column(columnDefinition = "tinyint", nullable = false)
    private int rstate;              // 객실 상태
    @Column(length = 20, nullable = false)

    // String 타입 One To One 선언 불가
    private String rgname;              // 객실 등급 이름, rgrade 테이블 fk

    public RoomDto toDto(){
        return RoomDto.builder()
                .rno(this.rno)
                .rstate(this.rstate)
                .build();
    }
}
