package hotelManagement.service.util;

import hotelManagement.model.dto.business.OperationStatisticsDto;

import java.util.List;
import java.util.Map;

public interface ReportStatistics {
    /*
    *   통계
    * */
    public abstract List<Map<String,Object>> reportStatistics( OperationStatisticsDto operationStatisticsDto );
    /*
     *   년 별
     * */
    public abstract List<Map<String,Object>> yearTotal();
    /*
     *   월 별
     * */
    public abstract List<Map<String,Object>> monthTotal( String year );
    /*
     *   주간 별
     * */
    public abstract List<Map<String,Object>> weekTotal( String year, String month );
}
