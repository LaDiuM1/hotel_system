package hotelManagement.service.guestroom;

import hotelManagement.model.dto.guestroom.RoomDto;
import hotelManagement.model.entity.guestroom.RoomEntity;
import hotelManagement.model.repository.guestroom.RoomEntityRepository;
import hotelManagement.model.repository.guestroom.RoomGradeEntityRepository;
import hotelManagement.model.repository.guestroom.RoomReservationEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomEntityRepository roomEntityRepository;
    @Autowired
    private RoomReservationEntityRepository roomReservationEntityRepository;
    @Autowired
    private RoomGradeEntityRepository roomGradeEntityRepository;

    @Transactional // 객실 정보 반환 함수
    public List<RoomDto> getGuestRoomList(){
        LocalDateTime nowDate = LocalDateTime.now();
        List<RoomEntity> RoomEntityList = roomEntityRepository.findAll();

        List<RoomDto> roomDtoList = new ArrayList<>();
        RoomEntityList.forEach( p -> {
            RoomDto roomDto = p.toDto();
            boolean enteringCheck = roomReservationEntityRepository
                    .existsByRoomEntity_RnoAndRrcheckinGreaterThanAndRrcheckoutLessThan(p.getRno(), nowDate, nowDate);
            int roomState = p.getRstate();
            if(enteringCheck && roomState == 1){
                roomDto.setRstate(1);
            }
            else if ( roomState == 0){
                roomDto.setRstate(3);
            }
            else {
                roomDto.setRstate(2);
            }

            roomDtoList.add(roomDto);
        });

        return roomDtoList;
    }


}
