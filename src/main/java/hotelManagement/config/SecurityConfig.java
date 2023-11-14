package hotelManagement.config;

import hotelManagement.controller.authLoginController.AuthLoginController;
import hotelManagement.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MemberService memberService;
    @Autowired
    private AuthLoginController authLoginController;

    @Override//HTTP 관련된 보안 담당하는 메소드
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests() // 1. 인증된 권한에 따른 HTTP 요청 제한.
                .antMatchers("/**").permitAll(); // 모든 페이지는 권한 모두 허용

        // 로그인 커스텀
        http.formLogin()
                .loginPage("/login")                                 // 로그인 사용할 http 주소 정의
                .loginProcessingUrl("/member/login")                // 로그인 요청 시 사용할 http 주소
                // HTTP '/member/login' POST 요청시 ---> MemberService의 loadUserByUsername 로 이동.
                .usernameParameter("eno")                         // 로그인시 입력받은 사번 변수명 정의
                .passwordParameter("epwd")                     //  로그인시 입력받은 비밀번호의 변수명 정의
                .defaultSuccessUrl("/hotelSystem")                  // 로그인 성공시 이동할 HTTP 주소
                .failureUrl("/login")            //  로그인 실패시 이동할 HTTP 주소
                .successHandler( authLoginController )              // 로그인 성공했을때 해당 클래스 매핑
                .failureHandler( authLoginController );             // 로그인 실패했을때 해당 클래스 매핑


        // csrf
        http.csrf().disable();

    }
}
