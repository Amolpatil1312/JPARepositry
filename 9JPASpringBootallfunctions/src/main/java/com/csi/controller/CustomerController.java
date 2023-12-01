package com.csi.controller;

import com.csi.exception.RecordNotFoundExeption;
import com.csi.model.Customer;
import com.csi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/app")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @PostMapping("/signup")
    public ResponseEntity<Customer> signUp(@Valid @RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.signUp(customer));
    }

    @GetMapping("/signin/{custEmail}/{custPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String custEmail,@PathVariable String custPassword){
        return ResponseEntity.ok(customerService.signIn(custEmail, custPassword));
    }

    @GetMapping("/findbyid/{custId}")
    public Optional<Customer> findById(@PathVariable int custId){
       return customerService.findById(custId);
    }
    @GetMapping("/findbyContactNumber/{custContactNumber}")
    public List<Customer> findByName(@PathVariable long custContactNumber){
        return customerService.findByContactNumber(custContactNumber);
    }

    @GetMapping("/findbyuid/{custuid}")
    public List<Customer> findByUID(@PathVariable long custuid){
        return customerService.findByUID(custuid);
    }

    @GetMapping("/findbydob/{custDOB}")
    public List<Customer> findByDob(@PathVariable String custDOB){
        return customerService.findByDOB(custDOB);
    }

    @GetMapping("/findbyfistname/{custFirstName}")
    public List<Customer> findByFirstName(@PathVariable String custFirstName){
        return customerService.findByFirstName(custFirstName);
    }

    @GetMapping("/findbylastname/{custLastName}")
    public List<Customer> findByLastName(@PathVariable String custLastName){
        return customerService.findByLastName(custLastName);
    }

    @GetMapping("/findbyemailid/{custEmail}")
    public List<Customer> findByEmailId(@PathVariable String custEmail){
        return customerService.findByEmailId(custEmail);
    }

    @GetMapping("/findall")
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @PostMapping("/savebulk")
    public List<Customer> saveBulk(@RequestBody List<Customer> customerList){
        return customerService.saveBuklOfData(customerList);
    }

    @GetMapping("/findbyanyinput/{anyinput}")
    public List<Customer> findByAnyInput(@PathVariable String anyinput){
        return customerService.findByAnyInput(anyinput);
    }

    @GetMapping("/sortbyid")
    public List<Customer> sortById(){
        return customerService.sortByID();
    }

    @GetMapping("/sortbyfirstname")
    public List<Customer> sortByFirstName(){
        return customerService.sortByFirstName();
    }

    @GetMapping("/sortbylastname")
    public List<Customer> sortByLastName(){
        return customerService.sortByLastName();
    }

    @GetMapping("/sortbysalary")
    public List<Customer> sortBySalary(){
        return customerService.sortBySalary();
    }

    @GetMapping("/sortbyDOB")
    public List<Customer> sortByDob(){
        return customerService.sortByDOB();
    }

    @GetMapping("/filterbysalary")
    public List<Customer> filterBySalary(){
        return customerService.filterBySalary(50000);
    }

    @PutMapping("/update/{custid}")
    public Customer update(@Valid @RequestBody Customer customer,@PathVariable int custid){
        Customer customer1 = findById(custid).orElseThrow(()->new RecordNotFoundExeption("Id is Not Available Into the Databes"));
        customer1.setCustFirstName(customer.getCustFirstName());
        customer1.setCustLastName(customer.getCustLastName());
        customer1.setCustAddress(customer.getCustAddress());
        customer1.setCustContactNumber(customer.getCustContactNumber());
        customer1.setCustDOB(customer.getCustDOB());
        customer1.setCustEmailId(customer.getCustEmailId());
        customer1.setCustSalary(customer.getCustSalary());
        customer1.setCustPanCardNumber(customer.getCustPanCardNumber());
        customer1.setCustUID(customer.getCustUID());

        return customerService.Update(customer1);

    }

    @DeleteMapping("/deletebyid/{custId}")
    public ResponseEntity<String> deleteById(int custId){
        customerService.deleteById(custId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAll(){
        customerService.deleteAll();
        return ResponseEntity.ok("All Data Deleted Successfully");
    }

    @GetMapping("/findLagestSalaryCustomer/{index}")
    public ResponseEntity<Customer> findSecondLargest(@PathVariable int index){
        return ResponseEntity.ok(customerService.findLagestSalaryCustomer(index));
    }





}
