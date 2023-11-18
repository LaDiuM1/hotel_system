package hotelManagement.service.employee;

import hotelManagement.model.dto.employee.EmployeeDto;
import hotelManagement.model.dto.employee.EmployeeManegementDto;
import hotelManagement.model.entity.employee.EmployeeEntity;
import hotelManagement.model.repository.employee.DepartmentEntityRepository;
import hotelManagement.model.repository.employee.EmployeeManegementRepository;
import hotelManagement.model.repository.employee.PositionEntityRepository;
import hotelManagement.service.util.TotalList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeManegementService implements TotalList< EmployeeManegementDto , List<Map<String,Object>> > {

    @Autowired
    // 직원 레포지토리
    private EmployeeManegementRepository employeeManegementRepository;
    @Autowired
    // 부서 레포지토리
    private DepartmentEntityRepository departmentEntityRepository;
    @Autowired
    // 직책 레포지토리
    private PositionEntityRepository positionEntityRepository;


    /*
    * getList 추상메서드 구현 직원 리스트 가져옴
    * */
    @Override
    public Map<String, Object> getList( EmployeeManegementDto employeeManegementDto ){

        // 검색 조건에 따른 employee 리스트
        List<Map<String,Object>> employeeList = employeeManegementRepository.findByCondition(
                employeeManegementDto.getDepart(), employeeManegementDto.getPosition()
                ,employeeManegementDto.getKeyword(), employeeManegementDto.getSearchType()
        );
        // 정렬 처리 후 employeeList에 반환
        employeeList = onSort(
                employeeList
                , employeeManegementDto.getPageAndSort().getCname()
                , employeeManegementDto.getPageAndSort().getIsSorted()
        );

        //페이징 처리 메서드 후 Controller에 반환
        return onPagging(
                employeeList
                ,employeeManegementDto.getPageAndSort().getNowPage()
                ,employeeManegementDto.getPageAndSort().getLimitPage()
                ,employeeList.size()
        );
    }
    /*
    * 페이징 처리 추상 메서드 구현
    * */
    @Override
    public Map<String,Object> onPagging( List<Map<String,Object>> employeeList, int page, int limitPage, int totalSize ){

        // 스킵할 행 개수
        final int startRow = (page-1) * limitPage;
        // 검색 결과에 따른 총 페이지 수
        int totalPage = totalSize%limitPage == 0 ? totalSize/limitPage : totalSize/limitPage+1 ;
        // 시작 버튼 정보
        int startBtn = ((page-1) / 5) * 5 + 1;
        // 종료 버튼 정보
        int endBtn = startBtn + 4;
        // endBtn이 총 페이지 수보다 크거나 같으면 endBtn에 총 페이지 수 대입
        if( endBtn >= totalPage ) endBtn = totalPage;
        // 종료 버튼 상수로 재선언
        final int finalEndBtn = endBtn;

        // 결과 반환
        return new HashMap<String,Object>(){{
            put("totalSize",totalSize);put("totalPage", totalPage);
            put("startBtn", startBtn);put("endBtn",finalEndBtn);
            // 페이지에 따른 검색결과 축소 skip( startRow )만큼 skip하고 limit( limitPage ) 크기로 제한함
            put("paggingResult" , employeeList.stream().skip( startRow ).limit( limitPage ));
        }};
    }

    /*
    *   정렬 추상 메서드 구현
    * */
    @SuppressWarnings("CallToPrintStackTrace")
    @Override
    public List<Map<String,Object>> onSort( List<Map<String,Object>> totalList, String columnName, String ascOrDesc ){
        // 정렬 요청 없을 시 메서드 종료
        if( columnName.isEmpty() )  return totalList;
        // 정렬 기준(내림차순,오름차순)
        final boolean finalAscOrDesc = Boolean.parseBoolean(ascOrDesc);
        // totalList 스트림
        final Stream<Map<String,Object>> mapStream = totalList.stream();

        try {
            // 입사일 정렬
            if( "ejoin".equals(columnName) )
                return mapStream.sorted( (a,b) -> finalAscOrDesc ?
                                ((Date)a.get(columnName)).compareTo((Date)b.get(columnName))
                                : ((Date)b.get(columnName)).compareTo((Date)a.get(columnName))
                        ).collect(Collectors.toList());
            // 그 외 나머지 정렬
            else
                return mapStream.sorted( (a,b) -> finalAscOrDesc ?
                                ((String)a.get(columnName)).compareTo((String)b.get(columnName))
                                : ((String)b.get(columnName)).compareTo((String)a.get(columnName))
                        ).collect(Collectors.toList());
        } catch (Exception e) {

            e.printStackTrace();
        }

        // 빈 배열 반환(예외 발생)
        return new ArrayList<>();
    }
    /*
    * 사원 정보 수정 메서드
    * */
    @Transactional
    public boolean putEmployee( EmployeeDto employeeDto ){
        // 입력받은 사원번호 데이터로 사원 엔티티 find
        Optional<EmployeeEntity> employeeEntityOptional = employeeManegementRepository.findByEno( employeeDto.getEno() );

        // 수정할 부서 엔티티와 직책 엔티티 find
        if( employeeEntityOptional.isPresent() ){
            EmployeeEntity employeeEntity = employeeEntityOptional.get();
            // 부서 엔티티 수정
            employeeEntity.setDepartmentEntity(
                    departmentEntityRepository.findByDname( employeeDto.getDepartmentDto().getDname() )
            );
            // 직책 엔티티 수정
            employeeEntity.setPositionEntity(
                    positionEntityRepository.findById( employeeDto.getPositionDto().getPname() ).get()
            );
            return true;
        }
        return false;
    }
}
