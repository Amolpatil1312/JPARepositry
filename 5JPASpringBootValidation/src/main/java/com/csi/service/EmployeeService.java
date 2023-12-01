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

    public Employee signUp(Employee employee){
        return employeeRepo.save(employee);
    }

    public boolean signIn(String empEmailId,String empPassword){
        Employee employee = employeeRepo.findByEmpEmailIdAndEmpPassword(empEmailId, empPassword);
        boolean flag = true;
        if(employee!=null && employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)){
           flag =true;
        }
        return flag;
    }

    public List<Employee> findAll(){
        return employeeRepo.findAll();
    }

    public Optional<Employee> findById(int empId){
        return employeeRepo.findById(empId);
    }

    public List<Employee> findByEmpName(String empName){
        return  employeeRepo.findByEmpName(empName);
    }

    public Employee findByContactNumber(long empContactNumber){
        return employeeRepo.findByEmpContactNumber(empContactNumber);
    }

    public Employee update(Employee employee){
        return employeeRepo.save(employee);
    }

    public void deleteById(int empId){
        employeeRepo.deleteById(empId);
    }

    public void deleteAll(){
        employeeRepo.deleteAll();
    }


}
