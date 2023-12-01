package com.csi.service;

import com.csi.model.Product;
import com.csi.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public Product signUp(Product product){
        return productRepo.save(product);
    }

    public List<Product> findAll(){
        return productRepo.findAll();
    }

    public boolean signIn(int prodId,String prodName){
        boolean flag = false;
        for(Product product : findAll()){

            if(product.getProdId()==prodId && product.getProdName().equals(prodName)){
                flag = true;
            }

        }
        return flag;
    }

    public Optional<Product> findById(int prodId){
        return productRepo.findById(prodId);
    }

    public List<Product> findByName(String prodName){
        return productRepo.findByProdName(prodName);
    }

    public void deleteById(int prodId){
        productRepo.deleteById(prodId);
    }

    public void deleteAll(){
        productRepo.deleteAll();
    }
}
