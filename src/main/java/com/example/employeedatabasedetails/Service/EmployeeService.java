package com.example.employeedatabasedetails.Service;

import com.example.employeedatabasedetails.Entity.DTO.EmployeeDto;
import com.example.employeedatabasedetails.Entity.EmployeeEntity;
import com.example.employeedatabasedetails.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

@Service
public class EmployeeService {
    @Autowired

    EmployeeRepository EmployeesRepository;
    public List<EmployeeEntity> getAllEmployeelist() {
        List<EmployeeEntity> allEmployeelist = EmployeesRepository.findAll();
        return allEmployeelist;
    }


    public EmployeeEntity getEmployees(Integer employeeId) {

        EmployeeEntity employeeEntity = EmployeesRepository.findByEmployeeId(employeeId);
        return employeeEntity;
    }

    public EmployeeEntity postEmployees(EmployeeEntity employeeEntity,String path, MultipartFile file) throws IOException{

        File files= new File(path+file.getOriginalFilename());
        files.createNewFile();
        FileOutputStream fout=new FileOutputStream(files);
        fout.write(file.getBytes());
        fout.close();

        employeeEntity.setFileName(file.getOriginalFilename());
        return EmployeesRepository.save(employeeEntity);
    }

    public ResponseEntity updateEmployee( EmployeeDto employeeDto, String path, MultipartFile file) throws IOException {
        EmployeeEntity employees = EmployeesRepository.findByEmployeeId(employeeDto.getEmployeeId());
        employees.setName(employeeDto.getName());
        employees.setDob(employeeDto.getDob());
        employees.setEmail(employeeDto.getEmail());
        employees.setPhoneno(employeeDto.getPhone());
         File files= new File(path+ file.getOriginalFilename());
        FileOutputStream fout=new FileOutputStream(files);
        files.createNewFile();
        fout.write(file.getBytes());
        fout.close();
        employees.setFileName(file.getOriginalFilename());
        EmployeesRepository.save(employees);
        return ResponseEntity.status(200).body("successfully updated");
    }
    public Map<String, Boolean> deleteEmployee( Integer employeeId){
        EmployeeEntity employees = EmployeesRepository.findAll().get(employeeId);
        EmployeesRepository.delete(employees);
        Map<String, Boolean> response= new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

