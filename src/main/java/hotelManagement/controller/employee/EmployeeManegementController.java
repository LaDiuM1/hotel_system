package hotelManagement.controller.employee;

import hotelManagement.model.dto.employee.EmployeeDto;
import hotelManagement.model.dto.employee.EmployeeManegementDto;
import hotelManagement.service.employee.EmployeeManegementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employeeManegement")
@CrossOrigin("http://localhost:3000")
public class EmployeeManegementController {

    @Autowired
    private EmployeeManegementService employeeManegementService;

    @PostMapping("")
    // 직원 리스트 담겨있는 Map 데이터 return
    public Map<String, Object> getEmployeeList(@RequestBody EmployeeManegementDto employeeManegementDto){
        System.out.println("employeeManegementDto = " + employeeManegementDto);

        return employeeManegementService.getList(employeeManegementDto);
    }
    @PutMapping("/updateEmployee")
    public boolean putEmployee( @RequestBody EmployeeDto employeeDto ){
        System.out.println("employeeDto = " + employeeDto);
        return employeeManegementService.putEmployee(employeeDto);
    }
}
