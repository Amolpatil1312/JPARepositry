package com.csi.controller;

import com.csi.exeption.RecordNotFoundExeption;
import com.csi.model.Customer;
import com.csi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/signup")
    public ResponseEntity<Customer> signUp(@RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.SignUp(customer));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/findbyname/{custName}")
    public ResponseEntity<List<Customer>> findByName(@PathVariable String custName){
        return ResponseEntity.ok(customerService.findByName(custName));
    }

    @GetMapping("/findbyemail/{custEmail}")
    public ResponseEntity<Customer> findByEmail(@PathVariable String custEmail){
        return ResponseEntity.ok(customerService.findByEmail(custEmail));
    }

    @GetMapping("/findbyemailpassword/{custEmail}/{custPassword}")
    public ResponseEntity<Customer> findByEmailPassword(@PathVariable String custEmail,@PathVariable String custPassword){
        return ResponseEntity.ok(customerService.findByEmailandpassword(custEmail, custPassword));
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Customer>> sortByName(){
        return ResponseEntity.ok(customerService.sortByName());
    }

    @GetMapping("/sortbysalary")
    public ResponseEntity<List> sortBySalary(){
        return ResponseEntity.ok(customerService.sortBySalary());
    }

    @GetMapping("/findbyid/{custId}")
    public Optional<Customer> findById(@PathVariable int custId){
        Optional<Customer> customer= Optional.ofNullable(customerService.findById(custId).orElseThrow(() -> new RecordNotFoundExeption("ID is Not Found")));
        return customer;
    }

    @PutMapping("/updatebyid/{custId}")
    public Customer updateById(@PathVariable int custId,@RequestBody Customer customer){
        Customer customer1 = findById(custId).orElseThrow(()-> new RecordNotFoundExeption("ID not Exist to Update"));

        customer1.setCustName(customer.getCustName());
        customer1.setCustAddress(customer.getCustAddress());
        customer1.setCustContactNumber(customer.getCustContactNumber());
        customer1.setCustEmailId(customer.getCustEmailId());
        customer1.setCustPassword(customer.getCustPassword());
        customer1.setCustSalary(customer.getCustSalary());

        return customerService.update(customer1);
    }

    @DeleteMapping("/deletebyid")
    public ResponseEntity<String> deletebyid(int custId){
       customerService.deletebyid(custId);
       return ResponseEntity.ok("deleted By Id done");
    }


}

