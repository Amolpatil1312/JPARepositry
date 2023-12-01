package com.csi.controller;

import com.csi.exeption.RecordNotFoundExeption;
import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@Valid @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.signUp(employee), HttpStatus.CREATED);
    }

    @GetMapping ("/signin/{empEmailId}/{empPassword}")
    public boolean signIn(@PathVariable String empEmailId, @PathVariable String empPassword){
        return employeeService.signIn(empEmailId, empPassword);
    }

    @GetMapping("/findbyid/{empId}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable int empId){
        return ResponseEntity.ok(Optional.ofNullable(employeeService.findById(empId).orElseThrow(() -> new RecordNotFoundExeption("Employee Id Not Exist"))));
    }

    @GetMapping("/findbyname/{empName}")
    public ResponseEntity<Employee> findByName(@PathVariable String empName){
        return  ResponseEntity.ok((Employee) employeeService.findByEmpName(empName));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<Employee> update(@PathVariable int empId,@RequestBody Employee employee){
        Employee employee1 = findById(empId).getBody().orElseThrow(()->new RecordNotFoundExeption("Record Not Available"));
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpPassword(employee.getEmpPassword());
        return new ResponseEntity<>(employeeService.update(employee),HttpStatus.CREATED);
    }

    @DeleteMapping("/deletebyid/{empId}")
    public ResponseEntity<String> deleteById(@PathVariable int empId){
        employeeService.deleteById(empId);
        return ResponseEntity.ok("Data deleted successfully");

    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAll(){
        employeeService.deleteAll();
        return ResponseEntity.ok("All data deleted successfully");
    }

}


