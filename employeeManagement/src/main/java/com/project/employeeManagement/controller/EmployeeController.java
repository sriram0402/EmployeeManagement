package com.project.employeeManagement.controller;

import com.project.employeeManagement.model.EmployeeModel;
import com.project.employeeManagement.service.EmployeeService;
import jakarta.servlet.annotation.HttpConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/employees")
    public Integer saveEmployee(@RequestBody() List<EmployeeModel> employeeDetails){
        try{
            return employeeService.saveEmployee(employeeDetails);
        }catch (Exception e){
            return e.hashCode();
        }

//        return "Success";
    }

    @GetMapping("/employees")
    public List<EmployeeModel> getEmployee(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public EmployeeModel getEmployeeById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id).getBody();
    }
    @PutMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Integer id, @RequestBody EmployeeModel employeeUpdateDetails){
        return employeeService.updateEmployee(id,employeeUpdateDetails);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        return employeeService.deleteEmployee(id);
    }

//    Swagger Documentation
//    http://localhost:8080/swagger-ui/index.html
}
