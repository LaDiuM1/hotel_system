package hotelManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Service
public class MemberService {

    @Autowired
    private HttpServletRequest request;
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
