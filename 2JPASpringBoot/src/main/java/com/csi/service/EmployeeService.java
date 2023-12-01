package com.csi.service;


import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public void save(Employee employee){
        employeeRepo.save(employee);
    }

    public Optional<Employee> findById(int empId){
        return employeeRepo.findById(empId);
    }

    public List<Employee> findAll(){
        return employeeRepo.findAll();
    }

    public Optional<Employee> update(Employee employee,int empId){
        employeeRepo.save(employee);
        return employeeRepo.findById(empId);
    }

    public void deleteById(int empId){
        employeeRepo.deleteById(empId);
    }

    public void deleteAll(){
        employeeRepo.deleteAll();
    }



}
