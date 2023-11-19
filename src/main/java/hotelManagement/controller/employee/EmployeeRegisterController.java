package hotelManagement.controller.employee;

import hotelManagement.model.dto.employee.EmployeeDto;
import hotelManagement.service.employee.EmployeeRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeeRegister")
public class EmployeeRegisterController {

    @Autowired
    private EmployeeRegisterService employeeRegisterService;

    @PostMapping("") // 직원 등록 함수
    public boolean employeeRegister(@RequestBody EmployeeDto employeeDto) {

        return employeeRegisterService.employeeRegister( employeeDto );

    }

}
