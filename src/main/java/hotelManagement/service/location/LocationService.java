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
        // 데이터 반환용 리스트 선언
        List<LocationDto> locationDtoList = new ArrayList<>();
        // 현재 날짜,시간 변수에 저장
        LocalDateTime nowDateTime = LocalDateTime.now();
        // 시설 정보 엔티티 리스트에 반환하여 저장
        List<LocationEntity> locationEntityList = locationEntityRepository.findAll();

        //시설별 순회
        locationEntityList.forEach( locationEntity ->{
            // 현재 날짜와 시간이 저장된 변수에 시설 운영 시작시간 / 종료시간을 입력하여 변수에 저장
            LocalDateTime startDateTime = nowDateTime.withHour(locationEntity.getLstarttime().getHour());
            LocalDateTime endDateTime = nowDateTime.withHour(locationEntity.getLendtime().getHour());

            // 필터를 사용하여 현재 순회중인 시설과 연관 관계를 가지고 있는 예약 정보의 날짜 / 시간과
            // 현재 시설의 운영시간과 비교하여 일치하면 리스트에 스트림으로 반환
            // 결과적으로 오늘 날짜의 각 예약 정보만 반환되어 리스트에 저장
            List<LocationReservationEntity> lrEntityList = locationEntity.getLresvList().stream().filter(o ->
                    o.getLrtime().isAfter(startDateTime) && o.getLrtime().isBefore(endDateTime))
                    .collect(Collectors.toList());
            // 시설 엔티티를 dto로 반환하는 메소드 실행하여 시설 dto로 저장
            LocationDto locationDto = locationEntity.toDto();
            // 예약 정보 엔티티 리스트를 반환용 예약 정보 dto 리스트로 변환하기 위한 리스트 선언
            List<LocationReservationDto> lrDtoList = new ArrayList<>();

            // 예약 정보 엔티티를 순회하여 각 엔티티에 저장된 필드 값을 DTO로 변환하여 순차적으로 리스트에 추가
            lrEntityList.forEach( p -> {
                lrDtoList.add(
                        LocationReservationDto.builder()
                                .lrno(p.getLrno())
                                .lrtime(p.getLrtime())
                                .build()
                );
            });
            // 모두 변환된 리스트를 순회 중인 시설 참조 객체에 저장
            locationDto.setLresvList(lrDtoList);
            // 반환용 리스트에 현재 시설 정보 추가
            locationDtoList.add( locationDto );
        });
        // 시설 종류 만큼 반복된 반복문 종료후 리스트 반환
        return locationDtoList;
    }


}
