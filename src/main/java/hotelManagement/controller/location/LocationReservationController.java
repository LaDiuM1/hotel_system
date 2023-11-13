package hotelManagement.controller.location;

import hotelManagement.model.dto.location.LocationSearchDto;
import hotelManagement.service.location.LocationReservationService;
import hotelManagement.service.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/locationReservation")
@CrossOrigin("http://localhost:3000")
public class LocationReservationController {
    @Autowired
    LocationReservationService locationReservationService;

    @PostMapping("")
    // 시설 예약 리스트 호출 메서드
    public Map<String,Object> getLocationReservation(@RequestBody LocationSearchDto locationSearchDto){
        System.out.println("locationSearchDto = " + locationSearchDto);
        locationReservationService.getList(locationSearchDto);
        return locationReservationService.getList(locationSearchDto);
    }
}
