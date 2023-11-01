package hotelManagement.service.guestroom;

import hotelManagement.model.dto.guestroom.RoomDto;
import hotelManagement.model.entity.guestroom.RoomEntity;
import hotelManagement.model.repository.guestroom.RoomEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomEntityRepository roomEntityRepository;

    @Transactional // 객실 정보 반환 함수
    public List<RoomDto> getGuestRoomList(){
        List<RoomEntity> RoomEntityList = roomEntityRepository.findAll();

    }


}
