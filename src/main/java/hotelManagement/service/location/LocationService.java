package hotelManagement.service.location;

import hotelManagement.model.dto.location.LocationDto;
import hotelManagement.model.dto.location.LocationReservationDto;
import hotelManagement.model.entity.locationEntity.LocationEntity;
import hotelManagement.model.entity.locationEntity.LocationReservationEntity;
import hotelManagement.model.repository.location.LocationEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {
    @Autowired
    LocationEntityRepository locationEntityRepository;


    @Transactional // 시설 관리 기능 데이터 호출 함수
    public List<LocationDto> getLocationList(){
        List<LocationDto> locationDtoList = new ArrayList<>();

        LocalDateTime nowDateTime = LocalDateTime.now();
        List<LocationEntity> locationEntityList = locationEntityRepository.findAll();

        locationEntityList.forEach( locationEntity ->{
            LocalDateTime startDateTime = nowDateTime.withHour(locationEntity.getLstarttime().getHour());
            LocalDateTime endDateTime = nowDateTime.withHour(locationEntity.getLendtime().getHour());

            List<LocationReservationEntity> lrEntityList = locationEntity.getLresvList().stream().filter(o ->
                    o.getLrtime().isAfter(startDateTime) && o.getLrtime().isBefore(endDateTime))
                    .collect(Collectors.toList());

            LocationDto locationDto = locationEntity.toDto();
            List<LocationReservationDto> lrDtoList = new ArrayList<>();

            lrEntityList.forEach( p -> {
                lrDtoList.add(
                        LocationReservationDto.builder()
                                .lrno(p.getLrno())
                                .lrtime(p.getLrtime())
                                .build()
                );
            });
            locationDto.setLresvList(lrDtoList);

            locationDtoList.add( locationDto );
        });
        return locationDtoList;
    }


}
