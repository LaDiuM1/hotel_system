package hotelManagement.controller.guestroom;

import hotelManagement.model.dto.guestroom.RoomDto;
import hotelManagement.service.guestroom.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guestRoom")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("") // 객실 정보 반환 함수
    public List<RoomDto> getGuestRoomList(){

        return roomService.getGuestRoomList();

    }

    @PutMapping("") // 객실 상태 변경 함수
    public boolean updateRoomState(@RequestBody RoomDto roomDto){
        return roomService.updateRoomState(roomDto);

    }

}
