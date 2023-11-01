package hotelManagement.controller;

import hotelManagement.model.dto.MemberDto;
import hotelManagement.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /*
    * 로그인 정보 호출
    * */
    @GetMapping("")
    public MemberDto getMemberInfo(){

        return null;
    }
    @GetMapping("/test")
    public boolean test(){
        return true;
    }
    /* 로그인
    * */
    @PostMapping("/login")
    public boolean onLogin( @RequestBody MemberDto memberDto ){
        return false;
    }

    /*
    *  사원 등록
    * */
    @PostMapping("")
    public boolean registerEmployee( @RequestBody MemberDto memberDto ){
        return false;
    }

    /*
    *  사원 정보 수정
    * */
    @PutMapping("")
    public boolean updateEmployee( @RequestBody MemberDto memberDto ){
        return false;
    }
    /*
    *  사원 정보 삭제
    * */
    @DeleteMapping("")
    public boolean deleteEmployee( @RequestParam int mno ){
        return false;
    }



}
