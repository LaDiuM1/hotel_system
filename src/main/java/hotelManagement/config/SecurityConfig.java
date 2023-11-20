package hotelManagement.config;

import hotelManagement.controller.authLoginController.AuthLoginController;
import hotelManagement.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MemberService memberService;
    @Autowired
    private AuthLoginController authLoginController;

    @Override//HTTP 관련된 보안 담당하는 메소드
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").authenticated() // "/" URL은 인증된 사용자에게만 허용
                .antMatchers("/reservation").authenticated() // 객실 예약 페이지
                .antMatchers("/locationReservation").authenticated() // 시설 예약 페이지

                .antMatchers("/roomManagement")     // 객실 관리 페이지 접근 url
                    .hasAnyRole("서비스_과장","서비스_차장"
                            ,"서비스_부장","서비스_이사"
                            ,"서비스_사장","총괄_사장")

                .antMatchers("/locationManagement")     // 시설 관리 페이지 접근 url
                    .hasAnyRole("시설관리_과장","시설관리_차장"
                            ,"시설관리_부장","시설관리_이사"
                            ,"시설관리_사장","총괄_사장")

                .antMatchers("/employeeManagement")         // 직원 관리 페이지 접근 url
                    .hasAnyRole(
                            "인사_사원","인사_주임"
                            ,"인사_대리","인사_과장"
                            ,"인사_차장","인사_부장"
                            ,"인사_이사","인사_사장","총괄_사장")

                .antMatchers("/employeeManegement/updateEmployee")  // 직원 수정 요청에 대한 url
                    .hasAnyRole(
                            "인사_차장","인사_부장"
                            ,"인사_이사","인사_사장","총괄_사장"
                    )
                .antMatchers("/revenueManagement")  // 경영 관리에 대한 url
                    .hasRole("총괄_사장")
                .antMatchers("/operationalStatistics")
                    .hasRole("총괄_사장")
                .antMatchers("operationalManagement")
                     .hasRole("총괄_사장")

                .antMatchers("/**").permitAll() // 다른 모든 URL은 누구에게나 허용(일시적)
              //.antMatchers("/접근 제한 주소").hasRole("권한명")
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/member/login")
                .usernameParameter("eno")
                .passwordParameter("epwd")
                .defaultSuccessUrl("/")
                .failureUrl("/login")
                .successHandler(authLoginController)
                .failureHandler(authLoginController);

        http.logout()                    // 1. 로그인(인증) 로그아웃 처리
                // 2. 로그아웃 처리할 HTTP 주소 정의
                .logoutRequestMatcher( new AntPathRequestMatcher("/member/logout") )
                // 3. 로그아웃 성공했을때 이동할 HTTP 주소 [ "/" : 메인페이지로 이동 ]
                .logoutSuccessUrl("/login")
                // 4. 로그아웃 할때 http세션 모두 초기화  [ true : 초기화O / false : 초기화X ]
                .invalidateHttpSession( true );

                http.csrf().disable();


       /* // 로그인 커스텀
        http.formLogin()
                .loginPage("/login")                                 // 로그인 사용할 http 주소 정의
                .loginProcessingUrl("/member/login")                // 로그인 요청 시 사용할 http 주소
                // HTTP '/member/login' POST 요청시 ---> MemberService의 loadUserByUsername 로 이동.
                .usernameParameter("eno")                         // 로그인시 입력받은 사번 변수명 정의
                .passwordParameter("epwd")                     //  로그인시 입력받은 비밀번호의 변수명 정의
                .defaultSuccessUrl("/hotelSystem")                  // 로그인 성공시 이동할 HTTP 주소
                .failureUrl("/login")            //  로그인 실패시 이동할 HTTP 주소
                .successHandler( authLoginController )              // 로그인 성공했을때 해당 클래스 매핑
                .failureHandler( authLoginController );             // 로그인 실패했을때 해당 클래스 매핑*/

    }
    @Override
    protected void configure( AuthenticationManagerBuilder auth) throws Exception {
        // super.configure(auth);
        auth.userDetailsService( memberService ).passwordEncoder( new BCryptPasswordEncoder() );
        // auth.userDetailsService( userDetailsService 구현체  ).passwordEncoder( 사용할 암호화 객체 )
    }



}
