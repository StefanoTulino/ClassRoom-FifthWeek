package com.corso.controller;


import com.corso.repository.domain.Product;
import com.corso.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("/getAll")
    public ResponseEntity<Product> getAll(){

        return new ResponseEntity(productService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    Optional<Product> findById(@PathVariable String id){
        return productService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    void deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
    }

    @PostMapping("/insert")
    public ResponseEntity<Product> insert(@RequestBody Product p){

        return new ResponseEntity(productService.insertProduct(p),HttpStatus.OK);
    }

    //NON VA
    @PutMapping(path="update/{id}")
    public ResponseEntity<?> updateDetails(@PathVariable(name="id") Integer id,@RequestParam String details, @RequestParam String value){
        productService.updateDetails(details,value);
        return new ResponseEntity("Record details aggiornato", HttpStatus.OK);
    }


}
