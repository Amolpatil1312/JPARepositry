package com.csi.service;

import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public Customer signUp(Customer customer){
      return customerRepo.save(customer);
    }

    public boolean signIn(String custEmail,String custPassword){
        boolean flag = false;
        Customer customer = customerRepo.findByCustEmailIdAndCustPassword(custEmail, custPassword);
        if(customer.getCustEmailId().equals(custEmail) && customer.equals(custPassword)){
            flag = true;
        }
        return flag;
    }

    public Optional<Customer> findById(int custId){
        return customerRepo.findById(custId);
    }

    public List<Customer> findAll(){
        return customerRepo.findAll();
    }

    public List<Customer> findByFirstName(String custName){
        return customerRepo.findAll().stream().filter(customer -> customer.getCustFirstName().equals(custName)).toList();
    }

    public List<Customer> findByLastName(String custName){
        return customerRepo.findAll().stream().filter(customer -> customer.getCustLastName().equals(custName)).toList();
    }

    public List<Customer> findByUID(long custUID){
        return customerRepo.findAll().stream().filter(customer -> customer.getCustUID()==custUID).toList();
    }

    public List<Customer> findByDOB(String custDOB){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return customerRepo.findAll().stream().filter(customer -> customer.getCustEmailId().equals(dateFormat.format(custDOB))).toList();
    }

    public List<Customer> findByEmailId(String custEmail){
        return customerRepo.findAll().stream().filter(customer -> customer.getCustEmailId().equals(custEmail)).toList();
    }
    public List<Customer> findByContactNumber(long custName){
        return customerRepo.findAll().stream().filter(customer -> customer.getCustContactNumber()==custName).toList();
    }

    public List<Customer> saveBuklOfData(List<Customer> customerList){
        return customerRepo.saveAll(customerList);
    }

    public List<Customer> findByAnyInput(String anyInput){
        return customerRepo.findAll().stream().filter(customer ->customer.getCustFirstName().equals(anyInput) || customer.getCustLastName().equals(anyInput)).toList();
    }

    public List<Customer> sortByFirstName(){
        return customerRepo.findAll().stream().sorted(Comparator.comparing(Customer::getCustFirstName)).toList();
    }

    public List<Customer> sortByLastName(){
        return customerRepo.findAll().stream().sorted(Comparator.comparing(Customer::getCustLastName)).toList();
    }

    public List<Customer> sortByID(){
        return customerRepo.findAll().stream().sorted(Comparator.comparing(Customer::getCustId)).toList();
    }

    public List<Customer> sortBySalary(){
        return customerRepo.findAll().stream().sorted(Comparator.comparing(Customer::getCustSalary)).toList();
    }

    public List<Customer> sortByDOB(){
        return customerRepo.findAll().stream().sorted(Comparator.comparing(Customer::getCustDOB)).toList();
    }
    public List<Customer> sortByEmailId() {
        return customerRepo.findAll().stream().sorted(Comparator.comparing(Customer::getCustEmailId)).toList();
    }

   public List<Customer> filterBySalary(double custSalary){
        return customerRepo.findAll().stream().filter(customer -> customer.getCustSalary()>=custSalary).toList();
   }

   public Customer Update(Customer customer){
        return customerRepo.save(customer);
   }

   public void deleteById(int custId){
        customerRepo.deleteById(custId);
   }

   public void deleteAll(){
        customerRepo.deleteAll();
   }

   public Customer findLagestSalaryCustomer(int index){
        return customerRepo.findAll().stream().sorted(Comparator.comparingDouble(Customer::getCustSalary).reversed()).toList().get(index);
   }



}
