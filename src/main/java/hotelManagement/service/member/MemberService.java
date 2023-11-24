package hotelManagement.service.member;

import hotelManagement.model.dto.employee.DepartmentDto;
import hotelManagement.model.dto.employee.EmployeeDto;
import hotelManagement.model.dto.employee.PositionDto;
import hotelManagement.model.dto.member.MemberDto;
import hotelManagement.model.dto.member.MemberInfoDto;
import hotelManagement.model.entity.employee.EmployeeEntity;
import hotelManagement.model.entity.member.MemberEntity;
import hotelManagement.model.entity.member.MemberInfoEntity;
import hotelManagement.model.repository.employee.EmployeeManegementRepository;
import hotelManagement.model.repository.member.MemberInfoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements UserDetailsService {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private EmployeeManegementRepository employeeManegementRepository;


    @Override // 로그인 시 유저 정보 시큐리티에게 반환하는 메서드
    public UserDetails loadUserByUsername( String eno ) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername eno = " + eno);
        // 입력한 사번으로 사원 정보 가져오기
        Optional<EmployeeEntity> employeeEntityOptional = employeeManegementRepository.findByEno( eno );
        // 없는 사번이라면 예외 던지기
        if( !employeeEntityOptional.isPresent() )
            throw new UsernameNotFoundException("없는 사번입니다.");

        EmployeeEntity employeeEntity = employeeEntityOptional.get();
        // 권한 목록
        List<GrantedAuthority> authorityList = new ArrayList<>();
        // 권한 목록에 추가 직급, 부서
        authorityList.add( new SimpleGrantedAuthority(
                "ROLE_"+employeeEntity.getDepartmentEntity().getDname()
                        + "_" +  employeeEntity.getPositionEntity().getPname() ));
        return EmployeeDto.builder()
                .eno(employeeEntity.getEno())       // 사번
                .epwd(employeeEntity.getEpwd())     // 비밀번호
                .authorityList(authorityList)       // 권한목록
                .build();
    }

    /*
    * 로그인 정보 호출
    * */
    @Transactional
    public EmployeeDto getMemberInfo(){
        // 인증에 성공한 정보 호출 [ 세션 호출 ]
        Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println( o.toString() );
        // 인증에 없을 때
        if( "anonymousUser".equals( o )) return null;
        // 인증 성공한 유저라면 정보 반환
        UserDetails userDetails = (UserDetails) o;
        Optional<EmployeeEntity> employeeEntityOptional = employeeManegementRepository.findByEno( userDetails.getUsername() );
        if( employeeEntityOptional.isPresent() ){
            EmployeeEntity employeeEntity = employeeEntityOptional.get();

            return EmployeeDto.builder()
                    .eno( employeeEntity.getEno() )
                    .memberInfoDto(MemberInfoDto.builder().mname(employeeEntity.getMemberInfoEntity().getMname()).build())
                    .departmentDto(DepartmentDto.builder().dname(employeeEntity.getDepartmentEntity().getDname()).build())
                    .positionDto(PositionDto.builder().pname(employeeEntity.getPositionEntity().getPname()).build())
                    .build();
        }
        return null;
    }




}
