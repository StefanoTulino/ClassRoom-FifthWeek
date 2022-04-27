package com.corso.classRoom.controller;


import com.corso.classRoom.domain.Product;
import com.corso.classRoom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@RestController
@RequestMapping("api/v1")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product saveProduct = productService.addProduct(product);
        return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
    }

    @GetMapping("products")
    public ResponseEntity<List<Product>> getAllProducts() {

        return new ResponseEntity<List<Product>>(
                (List<Product>) productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
        return new ResponseEntity<>(productService.getProductByid(id), HttpStatus.OK);
    }

    @DeleteMapping("product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") int id) {
        ResponseEntity<Product> responseEntity;
        Product deletedProduct = productService.deleteProductById(id);
        responseEntity = new ResponseEntity<Product>(deletedProduct, HttpStatus.OK);

        return responseEntity;
    }

}
