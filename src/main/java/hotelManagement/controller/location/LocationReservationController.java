package hotelManagement.controller.location;

import hotelManagement.model.dto.location.LocationSearchDto;
import hotelManagement.service.location.LocationReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/locationResv")
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
