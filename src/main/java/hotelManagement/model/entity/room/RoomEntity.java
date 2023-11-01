package hotelManagement.model.entity.room;

import lombok.*;

import javax.persistence.*;

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
    @Column(nullable = false)
    private boolean mname;              // 객실 상태
    @Column(length = 20, nullable = false)

    // String 타입 One To One 선언 불가
    private String rgname;              // 객실 등급 이름, rgrade 테이블 fk
}
