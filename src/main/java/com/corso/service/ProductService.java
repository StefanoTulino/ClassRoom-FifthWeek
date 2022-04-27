package com.corso.service;


import com.corso.repository.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAll();
    Product insertProduct(Product p);
    Optional<Product> findById(String id);
    void updateDetails(String details, String value);
    void deleteProduct(String id);

}
