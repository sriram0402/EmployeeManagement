package com.project.employeeManagement.repository;

import com.project.employeeManagement.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeModel,Integer> {
    @Override
    List<EmployeeModel> findAll();
    @Override
    Optional<EmployeeModel> findById(Integer integer);
    @Override
    void deleteById(Integer integer);
    @Override
    <S extends EmployeeModel> List<S> saveAll(Iterable<S> entities);
}
