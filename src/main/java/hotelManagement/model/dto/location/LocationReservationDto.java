package hotelManagement.model.dto.location;

import hotelManagement.model.entity.locationEntity.LocationReservationEntity;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class LocationReservationDto {
    private int lrno;           // 기본키
    private int lrstate;         // 시설 예약 상태 1, 2, 3
    private LocalDateTime lrtime;   // 시설 예약 시간
    private String lname;           // 시설 이름(필요시 객체로 대체)
    private int mno;                // 멤버 번호(필요시 객체로 대체)
    // 엔티티 변환 메서드
    // lname, mno 제외 된 상태 !!
    public LocationReservationEntity toEntity(){
        return LocationReservationEntity.builder()
                .lrno(this.lrno)
                .lrstate(this.lrstate)
                .lrtime(this.lrtime)
                .build();
    }
}
