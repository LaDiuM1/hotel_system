package hotelManagement.controller.location;

import hotelManagement.model.dto.location.LocationSearchDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locationReservation")
@CrossOrigin("http://localhost:3000")
public class LocationReservationController {

    @GetMapping("")
    public LocationSearchDto getLocationReservation(LocationSearchDto locationSearchDto){
        System.out.println("locationSearchDto = " + locationSearchDto);
        return null;
    }
}
