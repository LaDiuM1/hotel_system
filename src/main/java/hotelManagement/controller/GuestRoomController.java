package hotelManagement.controller;

import hotelManagement.model.dto.guestroom.RoomReservationDto;
import hotelManagement.model.dto.member.RoomSearchDto;
import hotelManagement.service.guestroom.RoomReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guestRoomReservation")
@CrossOrigin("http://localhost:3000")
public class GuestRoomController {

    @Autowired
    // 객실 예약 서비스
    private RoomReservationService roomService;

    @GetMapping("")
    // get 객실 예약 리스트
    public List<RoomReservationDto> getRoomReservation( RoomSearchDto roomSearchDto){
        System.out.println("roomSearchDto = " + roomSearchDto);

        return null;
    }

}
