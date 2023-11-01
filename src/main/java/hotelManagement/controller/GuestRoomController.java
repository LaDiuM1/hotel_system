package hotelManagement.controller;

import hotelManagement.model.dto.room.RoomReservationDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guestRoom")
public class GuestRoomController {

    @GetMapping("")
    public List<RoomReservationDto> getRoomReservation(@RequestParam String gname, String rrstartdate, String keyword){

        return null;
    }

}
