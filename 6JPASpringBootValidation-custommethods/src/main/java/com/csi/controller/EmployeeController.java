package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.signUp(employee));
    }

    @PostMapping("/savemultiple")
    public ResponseEntity<List<Employee>> saveBulk(@RequestBody List<Employee> list){
        List<Employee> list1=employeeService.saveBulk(list);
        return ResponseEntity.status(HttpStatus.CREATED).body(list1);
    }

    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public ResponseEntity<Boolean> signin(@PathVariable String empEmailId,@PathVariable String empPassword){
        return  ResponseEntity.ok(employeeService.signIn(empEmailId, empPassword));
    }
    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/findall/findbyid/{empId}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable int empId){
        Optional<Employee> employee = Optional.ofNullable(employeeService.findById(empId).orElseThrow(() -> new RecordNotFoundException("ID not Available in Database")));
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/findall/findbyname/{empName}")
    public ResponseEntity<List<Employee>> findByName(@PathVariable String empName){
        return ResponseEntity.ok(employeeService.findByName(empName));
    }

    @GetMapping("/findall/findbycontact/{empContact}")
    public ResponseEntity<Employee> findbycontact(@PathVariable long empContact){
        return ResponseEntity.ok(employeeService.findByContact(empContact));
    }
    @GetMapping("/findall/findemail/{empEmail}")
    public ResponseEntity<Employee> findbyemail(@PathVariable String empEmail){
        return ResponseEntity.ok(employeeService.findByEmail(empEmail));
    }

    @GetMapping("/findall/findByUID/{empUID}")
    public ResponseEntity<Employee> findByUID(@PathVariable long empUID){
        return ResponseEntity.ok(employeeService.findByUID(empUID));
    }
    @PutMapping("/updatebyid/{empId}")
    public ResponseEntity<Employee> updateById(@PathVariable int empId,@RequestBody Employee employee){
        Employee employee1 = findById(empId).getBody().orElseThrow(()->new RecordNotFoundException("ID Not exist"));
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpPan(employee.getEmpPan());
        employee1.setEmpDept(employee1.getEmpDept());
        employee1.setEmpPassword(employee.getEmpPassword());

         return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.updateById(empId, employee));
    }

    @DeleteMapping("/findall/deletebyid/{empId}")
    public ResponseEntity<String> deleteById (@PathVariable int empId){
        employeeService.deleteById(empId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }

    @DeleteMapping("/deleteall")
    public void deleteall(){
        employeeService.deleteAll();
    }
}
