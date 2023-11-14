package hotelManagement.service.employee;

import hotelManagement.model.dto.employee.EmployeeDto;
import hotelManagement.model.entity.employee.DepartmentEntity;
import hotelManagement.model.entity.employee.EmployeeEntity;
import hotelManagement.model.entity.employee.PositionEntity;
import hotelManagement.model.entity.member.MemberInfoEntity;
import hotelManagement.model.repository.employee.DepartmentEntityRepository;
import hotelManagement.model.repository.employee.EmployeeEntityRepository;
import hotelManagement.model.repository.employee.PositionEntityRepository;
import hotelManagement.model.repository.member.MemberInfoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class EmployeeRegisterService {

    @Autowired
    private EmployeeEntityRepository employeeEntityRepository;
    @Autowired
    private DepartmentEntityRepository departmentEntityRepository;
    @Autowired
    private PositionEntityRepository positionEntityRepository;
    @Autowired
    private MemberInfoEntityRepository memberInfoEntityRepository;

    @Transactional
    @PostMapping("") // 직원 등록 함수
    public boolean employeeRegister(EmployeeDto employeeDto) {
        // Dto -> Entity 변환
        EmployeeEntity employeeEntity = employeeDto.toEntity();
        
        // 회원 공통 정보 저장 후 엔티티 반환
        MemberInfoEntity memberInfoEntity = memberInfoEntityRepository.save(employeeDto.getMemberInfoDto().toEntity());
        // 부서 코드로 부서 엔티티 반환
        Optional<DepartmentEntity> departmentEntity = departmentEntityRepository.findById(employeeDto.getDepartmentDto().getDcode());
        // 직책 기본값인 "사원"에 해당하는 사원 엔티티 반환
        Optional<PositionEntity> positionEntity = positionEntityRepository.findById("사원");
        
        // 직원 엔티티에 회원 공통 정보 참조 엔티티 설정
        employeeEntity.setMemberInfoEntity(memberInfoEntity);
        // 직원 엔티티에 부서 참조 엔티티 설정, optional ifPresent로 null 값 아닐 때 저장
        departmentEntity.ifPresent(employeeEntity::setDepartmentEntity);
        // 직원 엔티티에 직책 탐조 엔티티 설정, optional ifPresent로 null 값 아닐 때 저장
        positionEntity.ifPresent(employeeEntity::setPositionEntity);

        // 사번 생성 절차 [ 기준 : 2자리수 연도 + 부서코드 + 부서 인원+1 4자리 ]
        // 입사년월일 변수에 저장
        LocalDate join = employeeEntity.getEjoin();
        // 부서 코드 변수에 저장
        String dcode = employeeEntity.getDepartmentEntity().getDcode();
        // 입사년월일을 2자리수 연도로 반환 (dateformat에 LocalDate -> Date 클래스로 변환하여 전달)
        String year = new SimpleDateFormat("yy").format(Date.valueOf(join));
        // 연도별 부서 인원 카운트+1 반환 하는 네이티브 쿼리에 부서, 입사년도 전달하여 4자리 레코드 숫자로 변환
        String record = String.format("%04d",employeeEntityRepository.record(dcode, Integer.toString(join.getYear())));
        
        // 사번 코드 합성하여 entity에 저장 [ 2자리수 연도 + 부서코드 + 부서인원+1 4자리 ]
        employeeEntity.setEno(year+dcode+record);

        // YYYY-MM-DD 형식의 생년월일을 yymmdd 형식으로 변환하여 변수에 저장
        String birth = new SimpleDateFormat("yyMMdd").format(Date.valueOf(memberInfoEntity.getMbirth()));

        // 초기 비밀번호인 생년월일을 해시코드로 암호화하여 저장
        employeeEntity.setEpwd(new BCryptPasswordEncoder().encode(memberInfoEntity.getMbirth()));
        // 회원 공통 정보 회원 구분 필드에 3[직원] 저장
        employeeEntity.getMemberInfoEntity().setMtype(3);

        // 최종 엔티티 레코드 저장 후 반환된 결과에서 저장 여부 확인을 위해 직원 번호가 공백인지 isEmpty로 논리 반환
        return !employeeEntityRepository.save(employeeEntity).getEno().isEmpty();

    }

}
