package hotelManagement.service.employee;

import hotelManagement.model.dto.employee.EmployeeManegementDto;
import hotelManagement.model.repository.employee.EmployeeManegementRepository;
import hotelManagement.service.getListInterface.GetListInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeManegementService implements GetListInterface {
    @Autowired
    private EmployeeManegementRepository employeeManegementRepository;

    @Override
    // 직원 리스트 getList
    public Map<String, Object> getList( Object employeeManegementObject ){

        EmployeeManegementDto employeeManegementDto = (EmployeeManegementDto) employeeManegementObject;
        // 검색 조건에 따른 employee 리스트
        List<Map<String,Object>> employeeList = employeeManegementRepository.findByCondition(
                employeeManegementDto.getDepart(), employeeManegementDto.getPosition()
                ,employeeManegementDto.getKeyword(), employeeManegementDto.getSearchType()
        );

        //페이징 처리 메서드
        return onPagging(
                employeeManegementDto.getPageAndSort().getNowPage()
                , employeeManegementDto.getPageAndSort().getLimitPage()
                ,employeeList.size(), employeeList
        );

    }
    @Override
    // 페이징 처리 추상 메서드 구현
    public Map<String,Object> onPagging( int page, int limitPage, int totalSize, Object recordList ){
        // 맵 객체 담은 리스트로 형변환
        List<Map<String,Object>> employeeList = (List<Map<String,Object>>) recordList;
        // 스킵할 행 개수
        final int startRow = (page-1) * limitPage;
        int totalPage = totalSize%limitPage == 0 ? totalSize/limitPage : totalSize/limitPage+1 ;
        int startBtn = ((page-1) / 5) * 5 + 1;
        int endBtn = startBtn + 4;
        // endBtn이 총 페이지 수보다 크거나 같으면 endBtn에 총 페이지 수 대입
        if( endBtn >= totalPage ) endBtn = totalPage;
        final int finalEndBtn = endBtn;

        // 결과 반환
        return new HashMap(){{
            put("totalSize",totalSize);put("totalPage", totalPage);
            put("startBtn", startBtn);put("endBtn",finalEndBtn);
            // 페이지에 따른 검색결과 축소 skip( startRow )만큼 skip하고 limit( limitPage ) 크기로 제한함
            put("paggingResult" , employeeList.stream().skip( startRow ).limit( limitPage ));
        }};
    }

}
