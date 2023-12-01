package com.csi.service;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public Employee signUp(Employee employee){
        return employeeRepo.save(employee);
    }
    public List<Employee> findAll(){
        return employeeRepo.findAll();
    }

    public boolean signIn(String empEmailId,String empPassword){
        boolean flag = false;

        for(Employee employee:findAll()){
            if (employee.getEmpEmailId().equals(empEmailId)
                    && employee.getEmpPassword().equals(empPassword)) {
                flag =true;
            }
        }
        return flag;
    }

    public Optional<Employee> findById(int empId){
        return employeeRepo.findById(empId);
    }

    public Employee update(Employee employee,int empId){
        return employeeRepo.save(employee);
    }

    public void deleteById(int empId){
        employeeRepo.deleteById(empId);
    }

    public void deleteAll(){
        employeeRepo.deleteAll();
    }
    //custom methods logic
    public Employee findByEmpName(String empName){
        return employeeRepo.findByEmpName(empName);
    }

    public void deleteByEmpName(String empName){
        employeeRepo.deleteByEmpName(empName);
    }

}
