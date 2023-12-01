package com.csi.repo;

import com.csi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    public Customer findByCustEmailIdAndCustPassword(String custEmail,String custPassword);



}
