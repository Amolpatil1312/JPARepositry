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

    public List<Employee> saveBulk(List<Employee> list){
        for(Employee employee : list){
            employeeRepo.save(employee);
        }
        return list;
    }

    public List<Employee> findAll(){
        return employeeRepo.findAll();
    }

    public boolean signIn(String empEmailId, String empPassword){
       Employee employee = employeeRepo.findByEmpEmailIdAndEmpPassword(empEmailId, empPassword);
       boolean flag = false;
        if (employee.getEmpEmailId().equals(empEmailId) &&
                employee.getEmpPassword().equals(empPassword)) {
            flag = true;
        }
        return flag;
    }

    public List<Employee> findByName(String empName){
        List<Employee> list = employeeRepo.findByEmpName(empName);
        return list;
    }

    public Optional<Employee> findById(int empId){
        return employeeRepo.findById(empId);
    }

    public Employee findByContact(long empContact){
        return employeeRepo.findByEmpContactNumber(empContact);
    }

    public Employee findByEmail(String empEmail){
        return employeeRepo.findByEmpEmailId(empEmail);
    }

    public Employee findByUID(long empUID){
        return employeeRepo.findByEmpUID(empUID);
    }

    public Employee updateById(int empId,Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee deleteById(int empId){
        employeeRepo.deleteById(empId);
        return null;
    }

    public void deleteAll(){
        for(Employee employee:findAll()){
            employeeRepo.delete(employee);
        }
    }


}
