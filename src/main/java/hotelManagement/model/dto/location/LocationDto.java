package hotelManagement.model.dto.location;

import hotelManagement.model.entity.locationEntity.LocationEntity;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class LocationDto {
    private String lname;      // 시설 이름
    private LocalTime lstarttime;   // 시설 운영 종료 시간
    private LocalTime lendtime;     // 시설 운영 시작 시간
    private int lprice;                 // 일반 요금
    private int lchildprice;            // 아동 요금
    private int lmaxcapa;               // 최대 수용 인원

    @ToString.Exclude
    @Builder.Default
    private List<LocationReservationDto> lresvList = new ArrayList<>();
    // 엔티티 변환 메서드
    public LocationEntity toEntity(){
        return LocationEntity.builder()
                .lname(this.lname)
                .lstarttime(this.lstarttime)
                .lendtime(this.lendtime)
                .lprice(this.lprice)
                .lchildprice(this.lchildprice)
                .lmaxcapa(this.lmaxcapa)
                .build();
    }
}
