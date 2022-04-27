package com.corso.service;

import com.corso.repository.domain.Product;
import com.corso.repository.ProductRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product insertProduct(Product p) {

        return productRepository.save(p);
    }

    @Override
    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public void updateDetails(String details, String value) {
        Query query= new Query(Criteria.where("details").is("details"));
        Update update= new Update();
        update.set("details",value);

        UpdateResult result= mongoTemplate.updateFirst(query,update, Product.class);
        System.out.println("Record dettagli modificato:" +result.getMatchedCount());
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

}
