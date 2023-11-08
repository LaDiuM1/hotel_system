package hotelManagement.controller.location;

import hotelManagement.model.dto.location.LocationDto;
import hotelManagement.service.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location")
@CrossOrigin("http://localhost:3000")
public class LocationController {
    @Autowired
    LocationService locationService;

    @GetMapping("") // 시설 관리 기능 데이터 호출 함수
    public List<LocationDto> getLocationList(){

        return locationService.getLocationList();
    }




}
