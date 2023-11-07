package hotelManagement.model.entity.locationEntity;

import hotelManagement.model.entity.BaseTime;
import hotelManagement.model.entity.member.MemberEntity;
import hotelManagement.model.entity.member.MemberInfoEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table( name = "lresv")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
public class LocationReservationEntity extends BaseTime {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int lrno;           // 기본키
    @Column(columnDefinition = "tinyint", nullable = false)
    private int lrstate;         // 시설 예약 상태 1, 2, 3
    @Column(nullable = false)
    private LocalDateTime lrtime;   // 시설 예약 시간

    @ManyToOne
    @JoinColumn( name = "lname")
    private LocationEntity locationEntity;      // 시설 엔티티 참조

    @ManyToOne
    @JoinColumn(name = "mno")
    private MemberInfoEntity memberInfoEntity;          // 멤버 엔티티 참조
}
