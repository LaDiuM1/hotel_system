package hotelManagement.controller.business;

import hotelManagement.model.dto.room.RoomGradeDto;
import hotelManagement.service.business.OperationalManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operationalManagement")
@CrossOrigin("http://localhost:3000")
public class OperationalManagementController {
    @Autowired
    private OperationalManagementService operationalManagementService;

    @GetMapping("/getRoomOpData") // 객실 운영 데이터 반환 함수
    public List<RoomGradeDto> getRoomOpData(){

        return operationalManagementService.getRoomOpData();

    }



}
