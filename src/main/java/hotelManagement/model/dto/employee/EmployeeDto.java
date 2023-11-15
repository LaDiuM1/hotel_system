package hotelManagement.model.dto.employee;

import hotelManagement.model.dto.member.MemberInfoDto;
import hotelManagement.model.entity.employee.EmployeeEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder    // 직원 정보 DTO
public class EmployeeDto implements UserDetails {

    // 권한 목록
    private List<GrantedAuthority> authorityList ;
    // 권한 목록 get
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {return authorityList;}
    // 사원 비밀번호
    @Override
    public String getPassword() {return epwd;}
    // 사번
    @Override
    public String getUsername() {return eno;}
    // 계정 만료여부
    @Override
    public boolean isAccountNonExpired() {return true;}
    // 계정 잠금 여부   true 열림  false 잠김
    @Override
    public boolean isAccountNonLocked() {return true;}
    // 계정 증명 여부
    @Override
    public boolean isCredentialsNonExpired() {return true;}
    // 계정 활성화 여부
    @Override
    public boolean isEnabled() {return true;}

    private String eno;         // 직원 사번 8자리 숫자 코드 [ 연도 2자리 + 부서 2자리 + 순서 레코드 번호 ]
    private String epwd;        // 직원 비밀번호
    private String eaddress;    // 직원 집주소
    private LocalDate ejoin;    // 직원 입사일

    private DepartmentDto departmentDto;  // 부서 참조 연관 관계 필드

    private MemberInfoDto memberInfoDto;  // 직원 정보 테이블 참조 연관 관계 필드

    private PositionDto positionDto;  // 직책 참조 연관 관계 필드

    // dto -> entity
    public EmployeeEntity toEntity(){
        return EmployeeEntity.builder()
                .eno(this.eno)
                .eaddress(this.eaddress)
                .ejoin(this.ejoin)
                .build();
    }


}
