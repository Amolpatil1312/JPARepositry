package com.csi.service;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {
    @Autowired
    EmployeeRepo employeeRepoimpl;

    public Employee save(Employee employee){
        return employeeRepoimpl.save(employee);
    }

    public Optional<Employee> findById(int empId){
        return employeeRepoimpl.findById(empId);
    }

    public List<Employee> findAll(){
        return employeeRepoimpl.findAll();
    }

    public void deleteById(int empId){
        employeeRepoimpl.deleteById(empId);
    }

    public List<Employee> findByEmpName(String empName){
        return employeeRepoimpl.findByEmpName(empName);
    }

    public List<Employee> findByEmpNameStartingWith(String preffix){
        return employeeRepoimpl.findByEmpNameStartingWith(preffix);
    }
    public List<Employee> findByEmpNameEndingWith(String suffix){
        return employeeRepoimpl.findByEmpNameEndingWith(suffix);
    }
    public List<Employee> findByEmpNameContaining(String words){
        return employeeRepoimpl.findByEmpNameContaining(words);
    }
}
