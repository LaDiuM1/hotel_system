package hotelManagement.model.entity.room;

import hotelManagement.model.dto.room.RoomDto;
import hotelManagement.model.entity.BaseTime;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "room")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class RoomEntity extends BaseTime {

    @Id
    private int rno;                    // 호실 번호 [ pk ]
    @Column(columnDefinition = "tinyint", nullable = false)
    private int rstate;              // 객실 상태

    @ManyToOne
    @JoinColumn( name = "rgname_fk")
    private RoomGradeEntity roomGradeEntity;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "roomEntity" )
    private List<RoomReservationEntity> RoomReservationEntityList = new ArrayList<>();

    public RoomDto toDto(){
        return RoomDto.builder()
                .rno(this.rno)
                .rstate(this.rstate)
                .rgname(this.roomGradeEntity.getRgname())
                .build();
    }
}
