package com.csi.controller;

import com.csi.exeption.RecordNotFoundExeption;
import com.csi.model.Customer;
import com.csi.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerServiceImpl;
    @PostMapping("/signup")
    public ResponseEntity<Customer> signUp(@RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerServiceImpl.signUp(customer));
    }

    @GetMapping("/signin/{custEmailId}/{custPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String custEmailId,String custPassword){
        return ResponseEntity.ok(customerServiceImpl.signIn(custEmailId, custPassword));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerServiceImpl.findAll());
    }

    @PutMapping("/update/{custId}")
    public ResponseEntity<Customer> update(@PathVariable int custId,@RequestBody Customer customer){
        Customer customer1 = findById(custId).getBody().orElseThrow(()->new RecordNotFoundExeption("ID Not Exist"));
        return ResponseEntity.ok(customerServiceImpl.update(customer));
    }

    @GetMapping("/findbyid/{custId}")
    public ResponseEntity<Optional<Customer>> findById(@PathVariable int custId){
        return ResponseEntity.ok(Optional.ofNullable(customerServiceImpl.findById(custId).orElseThrow(() -> new RecordNotFoundExeption("ID not found"))));
    }

    @DeleteMapping("/deletebyid/{custId}")
    public ResponseEntity<String> deleteById(@PathVariable int custId){
        customerServiceImpl.findById(custId).orElseThrow(()->new RecordNotFoundExeption("ID Not Found"));
        customerServiceImpl.deleteById(custId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAll(){
        customerServiceImpl.deleteAll();
        return ResponseEntity.ok("All Data Deleted Successfully");
    }





}
