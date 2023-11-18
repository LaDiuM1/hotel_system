package hotelManagement.service.business;

import hotelManagement.model.dto.location.LocationDto;
import hotelManagement.model.dto.room.RoomGradeDto;
import hotelManagement.model.entity.discount.DiscountEntity;
import hotelManagement.model.entity.locationEntity.LocationEntity;
import hotelManagement.model.entity.room.RoomGradeEntity;
import hotelManagement.model.repository.discount.DiscountEntityRepository;
import hotelManagement.model.repository.employee.EmployeeEntityRepository;
import hotelManagement.model.repository.location.LocationEntityRepository;
import hotelManagement.model.repository.room.RoomGradeEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OperationalManagementService {
    @Autowired
    private RoomGradeEntityRepository roomGradeEntityRepository;

    @Autowired
    private DiscountEntityRepository discountEntityRepository;

    @Autowired
    private LocationEntityRepository locationEntityRepository;

    @Autowired
    private EmployeeEntityRepository employeeEntityRepository;

    @Transactional  // 객실 운영 데이터 반환 함수
    public List<RoomGradeDto> getRoomOpData(){
        // 객실 운영 데이터 전체 호출
        List<RoomGradeEntity> roomGradeEntityList = roomGradeEntityRepository.findAll();
        // 반환용 리스트 선언
        List<RoomGradeDto> roomGradeDtoList = new ArrayList<>();

        roomGradeEntityList.forEach( roomGradeEntity -> {
            // 반환용 개별 dto 선언
            RoomGradeDto roomGradeDto = roomGradeEntity.toDto();
            // 객실 등급에 해당하는 할인율 엔티티 호출
            Optional<DiscountEntity> discountEntity = discountEntityRepository.findById(roomGradeDto.getRgname());
            // 반환 dto 할인율 필드에 호출된 엔티티의 할인율 저장
            discountEntity.ifPresent(entity -> roomGradeDto.setDrate(entity.getDrate()));
            // 반환용 List에 추가
            roomGradeDtoList.add(roomGradeDto);
        });
        // 각 dto정보가 추가된 리스트 반환
        return roomGradeDtoList;
    }

    @Transactional// 객실 운영 데이터 업데이트 함수
    public boolean updateRoomOpData( List<RoomGradeDto> roomGradeDtoList ){
        try{
            roomGradeDtoList.forEach( roomGradeDto -> {
               Optional<RoomGradeEntity> roomGradeEntityOptional = roomGradeEntityRepository.findById(roomGradeDto.getRgname());
               Optional<DiscountEntity> discountEntityOptional = discountEntityRepository.findById(roomGradeDto.getRgname());

               if(roomGradeEntityOptional.isPresent()) {
                   RoomGradeEntity roomGradeEntity = roomGradeEntityOptional.get();

                   roomGradeEntity.setRwprice(roomGradeDto.getRwprice());
                   roomGradeEntity.setRhprice(roomGradeDto.getRhprice());
                   roomGradeEntity.setRgmaxcapa(roomGradeDto.getRgmaxcapa());

                   discountEntityOptional.ifPresent( p -> {
                       p.setDrate(roomGradeDto.getDrate());
                   });
               }
            });
            return true;
        } catch (Exception e){
            return false; // 트랙잭션 롤백 발생 시 false 반환
        }
    }

    @Transactional  // 시설 운영 데이터 반환 함수
    public List<LocationDto> getLocationOpData(){
        // 시설 운영 데이터 전체 호출
        List<LocationEntity> locationEntityList = locationEntityRepository.findAll();
        // 반환용 리스트 선언
        List<LocationDto> locationDtoList = new ArrayList<>();

        locationEntityList.forEach( locationEntity -> {
            // 반환용 개별 dto 선언
            LocationDto locationDto = locationEntity.toDto();
            // 시설 등급에 해당하는 할인율 엔티티 호출
            Optional<DiscountEntity> discountEntity = discountEntityRepository.findById(locationEntity.getLname());
            // 반환 dto 할인율 필드에 호출된 엔티티의 할인율 저장
            discountEntity.ifPresent(entity -> locationDto.setDrate(entity.getDrate()));
            // 반환용 List에 추가
            locationDtoList.add(locationDto);
        });
        // 각 dto정보가 추가된 리스트 반환
        return locationDtoList;
    }

    @Transactional// 시설 운영 데이터 업데이트 함수
    public boolean updateLocationOpData( List<LocationDto> locationDtoList ){
        try{
            locationDtoList.forEach( locationDto -> {
                Optional<LocationEntity> locationEntityOptional = locationEntityRepository.findById(locationDto.getLname());
                Optional<DiscountEntity> discountEntityOptional = discountEntityRepository.findById(locationDto.getLname());

                if(locationEntityOptional.isPresent()) {
                    LocationEntity locationEntity = locationEntityOptional.get();

                    locationEntity.setLchildprice(locationDto.getLchildprice());
                    locationEntity.setLprice(locationDto.getLprice());
                    locationEntity.setLmaxcapa(locationDto.getLmaxcapa());
                    locationEntity.setLstarttime(locationDto.getLstarttime());
                    locationEntity.setLendtime(locationDto.getLendtime());

                    discountEntityOptional.ifPresent( p -> {
                        p.setDrate(locationDto.getDrate());
                    });
                }
            });
            return true;
        } catch (Exception e){
            return false; // 트랙잭션 롤백 발생 시 false 반환
        }
    }

}
