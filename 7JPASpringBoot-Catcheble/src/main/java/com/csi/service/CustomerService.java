package com.csi.service;

import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    public Customer SignUp(Customer customer){
        return customerRepo.save(customer);
    }

    public List<Customer> findAll(){
        return customerRepo.findAll();
    }

    public List<Customer> findByName(String custName){
        return  customerRepo.findByCustName(custName);
    }

    public Customer findByEmail(String custEmail){
        return customerRepo.findByCustEmailId(custEmail);
    }

    public Customer findByEmailandpassword(String custEmail,String custPassword){
        return customerRepo.findByCustEmailIdAndCustPassword(custEmail, custPassword);
    }

    public List<Customer> sortByName(){
        return customerRepo.findAll().stream().sorted(Comparator.comparing(Customer::getCustName)).toList();
    }

    public List<Customer> sortBySalary(){
        return customerRepo.findAll().stream().sorted(Comparator.comparing(Customer::getCustSalary)).toList();
    }

    @Cacheable(value = "empId")
    public Optional<Customer> findById(int empId){
        log.info("#############TRYING To Find By ID################");
        return customerRepo.findById(empId);
    }

    public Customer update(Customer customer){
        log.info("#############TRYING TO UPDATE BY ID################");
        return customerRepo.save(customer);
    }

    public void  deletebyid(int custId){
        customerRepo.deleteById(custId);
    }
}
