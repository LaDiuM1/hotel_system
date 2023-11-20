package hotelManagement.controller.member;

import hotelManagement.model.dto.employee.EmployeeDto;
import hotelManagement.model.dto.member.MemberDto;
import hotelManagement.service.member.MemberService;
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
    @GetMapping("/info")
    public EmployeeDto getMemberInfo(){
        return memberService.getMemberInfo();
    }
}
