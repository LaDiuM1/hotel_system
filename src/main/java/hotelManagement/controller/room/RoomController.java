package hotelManagement.controller.room;

import hotelManagement.model.dto.room.RoomDto;
import hotelManagement.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guestRoom")
@CrossOrigin("http://localhost:3000")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("") // 객실 정보 반환 함수
    public List<RoomDto> getGuestRoomList(){
        return roomService.getGuestRoomList();

    }

    @GetMapping("/checkout") // 퇴실 처리 함수
    public boolean checkout(@RequestParam int rrno){
        return roomService.checkout(rrno);

    }

    @PutMapping("") // 객실 상태 변경 함수
    public boolean updateRoomState(@RequestBody RoomDto roomDto){
        return roomService.updateRoomState(roomDto);

    }

}
