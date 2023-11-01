package hotelManagement.model.entity.room;

import lombok.*;

import javax.persistence.*;

@Entity
@Table( name = "rgrade")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class RoomGradeEntity {

    @Id
    @Column(length = 20)
    private String rgname;          // 객실 등급명 [ pk ]
    @Column(nullable = false)
    private int rwprice;            // 평일 객실 이용료
    @Column(nullable = false)
    private int rhprice;            // 주말 객실 이용료
    @Column(columnDefinition = "tinyint", nullable = false)
    private int rgmaxcapa;          // 객실 최대 수용 인원


}
