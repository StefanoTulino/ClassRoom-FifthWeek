package com.corso.classRoom.service;

import com.corso.classRoom.domain.Product;
import com.corso.classRoom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByid(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product deleteProductById(int id) {
        Product p=null;
        Optional<?> optional= productRepository.findById(id);
        if(optional.isPresent()){
            p= productRepository.findById(id).get();
            productRepository.deleteById(id);
        }
        return p;
    }
}
