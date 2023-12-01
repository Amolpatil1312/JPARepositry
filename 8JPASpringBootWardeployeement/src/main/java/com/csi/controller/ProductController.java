package com.csi.controller;

import com.csi.exeption.ProductNotFoundExeption;
import com.csi.model.Product;
import com.csi.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app")
@Slf4j
public class ProductController {
    @Autowired
    ProductService productService;


    @PostMapping("/signup")
    public ResponseEntity<Product> signUp(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.signUp(product));

    }

    @GetMapping("/signin/{custId}/{custName}")
    public ResponseEntity<Boolean> signIn(@PathVariable int custId,@PathVariable String custName){
        return ResponseEntity.ok(productService.signIn(custId, custName));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/findbyid/{custId}")
    @Cacheable(value = "custId")
    public ResponseEntity<Optional<Product>> findById(@PathVariable int custId){
        Optional<Product> product = Optional.ofNullable(productService.findById(custId).orElseThrow(() -> new ProductNotFoundExeption("This Product ID not Exist")));
        log.info("###########Trying to fetch data from database@########");
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @DeleteMapping("/deletebyid/{custId}")
    @Cacheable(value = "custId")
    public ResponseEntity<String> deleteById(@PathVariable int custId){
        productService.deleteById(custId);
        return ResponseEntity.ok("Data deleted Successfully..");
    }
}
