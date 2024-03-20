package com.project.employeeManagement.service;

import com.project.employeeManagement.model.EmployeeModel;
import com.project.employeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Integer saveEmployee(List<EmployeeModel> employeeDetails){
        return employeeRepository.saveAll(employeeDetails).size();
    }

    public List<EmployeeModel> getEmployees() {
        return employeeRepository.findAll();
    }
    public ResponseEntity<EmployeeModel> getEmployeeById(Integer id){

        try {
            Optional<EmployeeModel> byId = employeeRepository.findById(id);
            if(byId.isPresent()){
                return new ResponseEntity<EmployeeModel>(byId.get(),HttpStatus.OK);
            }

        }
        catch(Exception e){
            return new ResponseEntity<EmployeeModel>(HttpStatus.NO_CONTENT);
        }
        return null;
    }

    public String updateEmployee(Integer id, EmployeeModel employeeUpdateDetails) {

        try{
            Optional<EmployeeModel> employeeById = employeeRepository.findById(id);
            if (employeeById.isEmpty()) {
                return "No Employee Found";
            } else {


                employeeById.get().setFirstName(employeeUpdateDetails.getFirstName());
                employeeById.get().setLastName(employeeUpdateDetails.getLastName());
                employeeById.get().setBirthDate(employeeUpdateDetails.getBirthDate());
                employeeById.get().setPhone(employeeUpdateDetails.getPhone());
                employeeById.get().setEmailAddress(employeeUpdateDetails.getEmailAddress());
                employeeById.get().setDepartment(employeeUpdateDetails.getDepartment());
                employeeById.get().setJobTitle(employeeUpdateDetails.getJobTitle());
                employeeById.get().setLocation(employeeUpdateDetails.getLocation());
                employeeById.get().setStartDate(employeeUpdateDetails.getStartDate());
                employeeById.get().setManagerReporting(employeeUpdateDetails.getManagerReporting());
                employeeRepository.save(employeeById.get());
                return "employee Details Updated";
            }
        }
        catch(Exception e){
            return "Invalid";
        }

    }

    public String deleteEmployee(Integer id) {

        try{
            Optional<EmployeeModel> employeeById = employeeRepository.findById(id);
            if (employeeById.isEmpty()) {
                return "No Employee Found";
            } else {
                employeeRepository.deleteById(id);
                return "Employee Deleted";
            }
        }
        catch (Exception e){
            return "Invalid";
        }
    }
}
