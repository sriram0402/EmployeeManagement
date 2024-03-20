package com.project.employeeManagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
//    	FIRSTNAME 
//            	LASTNAME 
//            	EMAILADDRESS 
//            	PHONE 
//            	BIRTHDATE 
//            	JOB-TITLE 
//            	DEPARTMENT 
//            	LOCATION 
//            	STARTDATE 
//            	EMPLOYEEID 
//            	MANAGER-REPORTING 

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phone;
    @DateTimeFormat(pattern="MM-dd-YYY")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDate;
    private String jobTitle;
    private String department;
    private String location;
    @DateTimeFormat(pattern="MM-dd-YYY")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String managerReporting;

}
