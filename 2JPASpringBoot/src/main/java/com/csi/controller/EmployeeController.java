package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeServiceimpl;

    @PostMapping("/save")
    public void save(@RequestBody Employee employee){
        employeeServiceimpl.save(employee);
    }

    @GetMapping("/findbyid/{empId}")
    public Optional<Employee> findById(@PathVariable int empId){
        return employeeServiceimpl.findById(empId);
    }

    @PutMapping("/update/{empId}")
    public Optional<Employee> updatebyid(@RequestBody Employee employee, @PathVariable int empId){
        return employeeServiceimpl.update(employee,empId);
    }
    @GetMapping("/findall")
    public List<Employee> findAll(){
        return employeeServiceimpl.findAll();
    }

    @DeleteMapping("/deletebyid/{empId}")
        public void deleteById(@PathVariable int empId){
            employeeServiceimpl.deleteById(empId);
        }

}
