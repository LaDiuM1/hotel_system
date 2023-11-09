package hotelManagement.controller.location;

import hotelManagement.model.dto.location.LocationSearchDto;
import hotelManagement.service.location.LocationReservationService;
import hotelManagement.service.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/locationReservation")
@CrossOrigin("http://localhost:3000")
public class LocationReservationController {
    @Autowired
    LocationReservationService locationReservationService;

    @GetMapping("")
    // 시설 예약 리스트 호출 메서드
    public Map<String,Object> getLocationReservation(LocationSearchDto locationSearchDto){
        System.out.println("locationSearchDto = " + locationSearchDto);
        locationReservationService.getLocationReservation(locationSearchDto);
        return locationReservationService.getLocationReservation(locationSearchDto);
    }
}
