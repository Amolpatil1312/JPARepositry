package com.csi.repo;

import com.csi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface ProductRepo extends JpaRepository<Product,Integer> {
    //custom methods
    public List<Product> findByProdName(String prodName);


}
