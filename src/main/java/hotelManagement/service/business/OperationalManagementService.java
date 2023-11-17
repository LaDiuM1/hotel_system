package hotelManagement.service.business;

import hotelManagement.model.dto.room.RoomGradeDto;
import hotelManagement.model.entity.discount.DiscountEntity;
import hotelManagement.model.entity.room.RoomGradeEntity;
import hotelManagement.model.repository.discount.DiscountEntityRepository;
import hotelManagement.model.repository.room.RoomGradeEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
