package hotelManagement.controller.business;

import hotelManagement.model.dto.employee.PositionDto;
import hotelManagement.model.dto.location.LocationDto;
import hotelManagement.model.dto.room.RoomGradeDto;
import hotelManagement.service.business.OperationalManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operationalManagement")
public class OperationalManagementController {
    @Autowired
    private OperationalManagementService operationalManagementService;

    @GetMapping("/getRoomOpData") // 객실 운영 데이터 반환 함수
    public List<RoomGradeDto> getRoomOpData(){

        return operationalManagementService.getRoomOpData();

    }
    
    @PostMapping("/updateRoomOpData") // 객실 운영 데이터 업데이트 함수
    public boolean updateRoomOpData(@RequestBody List<RoomGradeDto> roomGradeDtoList){

        return operationalManagementService.updateRoomOpData(roomGradeDtoList);
    }

    @GetMapping("/getLocationOpData") // 시설 운영 데이터 반환 함수
    public List<LocationDto> getLocationOpData(){

        return operationalManagementService.getLocationOpData();

    }


    @PostMapping("/updateLocationOpData") // 시설 운영 데이터 업데이트 함수
    public boolean updateLocationOpData(@RequestBody List<LocationDto> locationDtoList){

        return operationalManagementService.updateLocationOpData(locationDtoList);
    }

    @GetMapping("/getPositionOpData") // 인사 데이터 반환 함수
    public List<PositionDto> getPositionOpData(){

        return operationalManagementService.getPositionOpData();

    }


    @PostMapping("/updatePositionOpData") // 인사 데이터 업데이트 함수
    public boolean updatePositionOpData(@RequestBody List<PositionDto> PositionDtoList){

        return operationalManagementService.updatePositionOpData(PositionDtoList);
    }



}
