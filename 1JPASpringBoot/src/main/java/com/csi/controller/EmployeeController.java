package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceimpl;

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee){
        return employeeServiceimpl.save(employee);
    }

    @GetMapping("findbyid/{empId}")
    public Optional<Employee> findById(@PathVariable int empId){
        return employeeServiceimpl.findById(empId);
    }

    @GetMapping("/findall")
    public List<Employee> findall(){
        return employeeServiceimpl.findAll();
    }

    @DeleteMapping("/deletebyid/{empId}")
    public void deleteById(@PathVariable int empId){
        employeeServiceimpl.deleteById(empId);
    }

    @GetMapping("/findbyname/{empName}")
    public List<Employee> findByName(@PathVariable String empName){
        return employeeServiceimpl.findByEmpName(empName);
    }

    @GetMapping("/namestartwith/{preffix}")
    public List<Employee> findByEmpNameStartingWith(String preffix){
        return employeeServiceimpl.findByEmpNameStartingWith(preffix);
    }
    @GetMapping("/nameendwith/{suffix}")
    public List<Employee> findByEmpNameEndingWith(String suffix){
        return employeeServiceimpl.findByEmpNameEndingWith(suffix);
    }

    @GetMapping("/namecontaining/{word}")
    public List<Employee> findByEmpNameContaining(String words){
        return employeeServiceimpl.findByEmpNameContaining(words);
    }
}
