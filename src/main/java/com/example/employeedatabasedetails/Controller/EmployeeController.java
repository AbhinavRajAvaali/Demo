package com.example.employeedatabasedetails.Controller;

import com.example.employeedatabasedetails.Entity.DTO.EmployeeDto;
import com.example.employeedatabasedetails.Entity.EmployeeEntity;
import com.example.employeedatabasedetails.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/Employees")
public class EmployeeController {

    @Value("${practice.path}")
    private String path;
    @Autowired
    private EmployeeService employeeService;;
    @GetMapping("/getAllEmployees")
    public List<EmployeeEntity> getAllEmployee(){
        return employeeService.getAllEmployeelist();

    }
    @GetMapping("/getEmployees")
    public EmployeeDto getEmployeeById(@RequestParam Integer id)  {
        EmployeeEntity employee= employeeService.getEmployees(id);
        EmployeeDto employeeDto=new EmployeeDto();
        employeeDto.setName(employee.getName());
        employeeDto.setPhone(employee.getPhoneno());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setDob(employee.getDob());
        return employeeDto;
    }
    @PostMapping("/createEmployees")
    public EmployeeEntity createEmployee(@RequestPart EmployeeEntity employeeEntity,
                                         @RequestPart(value = "image",required = false)
                                         MultipartFile image)throws IOException{

        return employeeService.postEmployees(employeeEntity,path,image);
    }
    @PutMapping("/updateEmployees")
    public ResponseEntity updateEmployee(@RequestPart EmployeeDto employeeDto,@RequestPart(value = "image", required = false)
                   MultipartFile image) throws IOException {

        return employeeService.updateEmployee(employeeDto,path,image);
    }
    @DeleteMapping("/deleteEmployees")
    public Map<String, Boolean> deleteEmployee (@RequestParam Integer employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }
}