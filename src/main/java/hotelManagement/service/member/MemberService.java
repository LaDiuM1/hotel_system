package hotelManagement.service.member;

import hotelManagement.model.dto.employee.EmployeeDto;
import hotelManagement.model.dto.member.MemberDto;
import hotelManagement.model.entity.employee.EmployeeEntity;
import hotelManagement.model.entity.member.MemberInfoEntity;
import hotelManagement.model.repository.employee.EmployeeManegementRepository;
import hotelManagement.model.repository.member.MemberInfoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpServletRequest;
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
        System.out.println("실행"+ employeeEntity);
        // 권한 목록
        List<GrantedAuthority> authorityList = new ArrayList<>();
        // 권한 목록에 추가 직급, 부서
        authorityList.add( new SimpleGrantedAuthority( "ROLE_"+employeeEntity.getPositionEntity().getPname() ));
        authorityList.add( new SimpleGrantedAuthority( "ROLE_"+employeeEntity.getDepartmentEntity().getDname() ));
        System.out.println("실행"+ authorityList);
        return EmployeeDto.builder()
                .eno(employeeEntity.getEno())       // 사번
                .epwd(employeeEntity.getEpwd())     // 비밀번호
                .authorityList(authorityList)       // 권한목록
                .build();
    }

    /*
    * 로그인 정보 호출
    * */
    public MemberDto getMemberInfo(){

        return null;
    }
    /*
    * 로그인
    * */
    public boolean onLogin( MemberDto memberDto ){

        return false;
    }
    /*
    * 사원 등록
    * */
    public boolean registerEmployee( MemberDto memberDto ){
        return false;
    }
    /*
    *  사원 정보 수정
    * */
    @PutMapping("")
    public boolean updateEmployee(  MemberDto memberDto ){
        return false;
    }
    /*
     *  사원 정보 삭제
     * */
    @DeleteMapping("")
    public boolean deleteEmployee(  int mno ){
        return false;
    }

}
