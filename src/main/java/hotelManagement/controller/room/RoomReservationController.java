package hotelManagement.controller.room;

import hotelManagement.model.dto.room.RoomSearchDto;
import hotelManagement.service.room.RoomReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/guestRoomReservation")
@CrossOrigin("http://localhost:3000")
public class RoomReservationController {

    @Autowired
    // 객실 예약 서비스
    private RoomReservationService roomService;

    @PostMapping("")
    // get 객실 예약 리스트
    public Map<String,Object> getRoomReservation(@RequestBody RoomSearchDto roomSearchDto){
        System.out.println("roomSearchDto = " + roomSearchDto);
        return roomService.getList(roomSearchDto);
    }

}
