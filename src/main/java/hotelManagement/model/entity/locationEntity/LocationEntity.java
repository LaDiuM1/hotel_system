package hotelManagement.model.entity.locationEntity;

import hotelManagement.model.entity.BaseTime;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "location")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
public class LocationEntity extends BaseTime {
    @Id
    @Column(length = 20)
    private String lname;      // 시설 이름
    @Column(nullable = false)
    private LocalTime lstarttime;   // 시설 운영 종료 시간
    @Column(nullable = false)
    private LocalTime lendtime;     // 시설 운영 시작 시간
    @Column(nullable = false)
    private int lprice;                 // 일반 요금
    @Column(nullable = false)
    private int lchildprice;            // 아동 요금
    @Column(columnDefinition = "smallint", nullable = false)
    private int lmaxcapa;               // 최대 수용 인원

    @Builder.Default
    @OneToMany(mappedBy = "locationEntity")
    List<LocationReservationEntity> lresvList = new ArrayList<>(); // 양방향 시설 예약 엔티티 리스트
}
