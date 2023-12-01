package com.csi.service;

import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl {

    @Autowired
    CustomerRepo customerRepoimpl;

    public Customer signUp(Customer customer){
        return  customerRepoimpl.save(customer);
    }

    public boolean signIn(String custEmailId,String custPassword){
        boolean flag = false;
        for(Customer customer:findAll()){
            if(customer.getCustEmailid().equals(custEmailId)&&
            customer.getCustPassword().equals(custPassword)){
                flag = true;
            }
        }
        return flag;
    }
    public Customer update(Customer customer){
      return customerRepoimpl.save(customer);
    }

    public List<Customer> findAll(){
        return customerRepoimpl.findAll();
    }

    public Optional<Customer> findById(int CustId){
        return customerRepoimpl.findById(CustId);
    }

    public void deleteById(int custId){
        customerRepoimpl.deleteById(custId);
    }

    public void deleteAll(){
        customerRepoimpl.deleteAll();
    }
}
