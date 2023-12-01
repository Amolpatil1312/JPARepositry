package com.csi.controller;

import com.csi.exeption.RecordNotFoundExeption;
import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.signUp(employee));
    }

    @PostMapping("/signIn")
    public ResponseEntity<Boolean> signIn(@RequestParam String empEmailId,String empPassword){
        return ResponseEntity.ok(employeeService.signIn(empEmailId, empPassword));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/findbyid/{empId}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable int empId) {
        return ResponseEntity.ok(Optional.ofNullable(employeeService.findById(empId).orElseThrow(() -> new RecordNotFoundExeption("ID Not Exist Into DataBase"))));
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<Employee> updateById(@RequestBody Employee employee, @PathVariable int empId) {
        Employee employee1 = findById(empId).getBody().orElseThrow(()->new RecordNotFoundExeption("ID Not Exist To Update"));
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpcontactNumber(employee.getEmpcontactNumber());
        employee1.setEmpPassword(employee.getEmpPassword());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        return ResponseEntity.ok(employeeService.update(employee,empId));
    }
    @DeleteMapping("/deletebyid/{empId}")
    public ResponseEntity<String> deleteById(@PathVariable int empId){
        Employee employee = findById(empId).getBody().orElseThrow(()->new RecordNotFoundExeption("Id is Not Available to Delete"));
        employeeService.deleteById(empId);
        return ResponseEntity.ok("Data Deleted Successfully..");
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAll(){
        employeeService.deleteAll();
        return ResponseEntity.ok("All Data Deleted Successfully");
    }

    @GetMapping("/findbyname/{empName}")
    public ResponseEntity<Employee> findByEmpName(@PathVariable String empName){
       return ResponseEntity.ok(employeeService.findByEmpName(empName));
    }

    @DeleteMapping("/deletebyempname/{empName}")
    public ResponseEntity<String> deleteByEmpName(@PathVariable String empName){
        employeeService.deleteByEmpName(empName);
        return ResponseEntity.ok("BY Name Data Deletetion Done");
    }

    @RequestMapping("/index")
    public String index(){

        return "index";
    }
}
