package hotelManagement.controller.business;

import hotelManagement.model.dto.business.OperationStatisticsDto;
import hotelManagement.service.Business.OperationStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/operationStatistics")
@CrossOrigin("http://localhost:3000")
public class OperationStatisticsController {

    @Autowired
    private OperationStatisticsService operationStatisticsService;

    /* 통계 가져오기 */
    @GetMapping("")
    public List<Map<String,String>> getStatistics(OperationStatisticsDto operationStatisticsDto ){
        System.out.println("operationStatisticsDto = " + operationStatisticsDto);
        return null;
    }


}