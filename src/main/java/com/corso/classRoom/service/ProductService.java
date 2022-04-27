package com.corso.classRoom.service;

import com.corso.classRoom.domain.Product;
import java.util.List;

public interface ProductService {


    Product addProduct(Product product);
    List<Product> getAllProducts();
    Product getProductByid(int id);
    Product deleteProductById(int id);

}
