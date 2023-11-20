package hotelManagement.controller.business;

import hotelManagement.model.dto.business.OperationStatisticsDto;

import hotelManagement.service.business.staticsService.TotalSalesStatisticsService;
import hotelManagement.service.business.staticsService.TotalUserStatisticsService;
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
    private TotalSalesStatisticsService totalSalesStatisticsService;
    @Autowired
    private TotalUserStatisticsService totalUserStatisticsService;

    /* 통계 가져오기 */
    @GetMapping("")
    public List<Map<String,Object>> getStatistics(OperationStatisticsDto operationStatisticsDto ){
        System.out.println("operationStatisticsDto = " + operationStatisticsDto);
        String wholeCategory = operationStatisticsDto.getWholeCategory();
        // 카테고리가 매출/사용자 수에 따라 다른 처리 경로
        if( "sales".equals(wholeCategory) )
            return totalSalesStatisticsService.reportStatistics( operationStatisticsDto );
        else
            return totalUserStatisticsService.reportStatistics( operationStatisticsDto );
    }


}
