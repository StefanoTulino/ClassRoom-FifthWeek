package com.corso.classRoom.respository;


import com.corso.classRoom.domain.Product;
import com.corso.classRoom.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//per avere a disposizione assertEquals
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    Product product;

    @BeforeEach
    public void setUp(){
        product= new Product(1,"Bat",2500);
    }

    @AfterEach
    public void tearDown(){
        productRepository.deleteAll();
        product=null;
    }

    @Test
    public void givenProductToAddShouldReturnAddedProduct(){
        productRepository.save(product);
        Product fetchedProduct= productRepository.findById(product.getId()).get();
        //mettiamo il valore che ci aspettiamo di ricevere
        assertEquals(1,fetchedProduct.getId());
        //non deve essere per forza 1 il valore di id, basta che ci sia un product costruito bene

    }

    @Test
    public void givenGetAllProductShouldReturnListOfAllProduct(){
        Product product1=new Product(1,"ball",400);
        Product product2=new Product(2,"bat",500);
        productRepository.save(product1);
        productRepository.save(product2);

        List<Product> productList= (List<Product>)  productRepository.findAll();
        assertEquals("bat",productList.get(1).getName());

    }

    @Test
    public void givenIdTODeleteThenShouldDeleteTheProduct(){
        Product product1= new Product(4,"gamePlay",450);
        productRepository.save(product1);
        productRepository.deleteById(product1.getId());
        assertEquals(Optional.empty(),productRepository.findById(product1.getId()));
    }

    @Test
    public void givenIdTODeleteThenShouldDeleteTheProduct2(){
        productRepository.save(product);
        productRepository.deleteById(product.getId());
        assertEquals(Optional.empty(),productRepository.findById(product.getId()));
    }



    @Test
    public void DeleteAllTheProduct(){
        Product product= new Product(3,"game",600);
        Product product1= new Product(4,"gamePlay",450);
        productRepository.save(product);
        productRepository.save(product1);
        productRepository.deleteAll();
        assertEquals(0,productRepository.count());
    }

}
