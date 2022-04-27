package com.corso.classRoom.controller;

import com.corso.classRoom.domain.Product;
import com.corso.classRoom.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

//per usare when e verify di MOCKITO
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    Product product, product2;
    List<Product> productList;

    @InjectMocks
    ProductController productController;

    @BeforeEach
    public void setUp(){
        product= new Product(1,"Bat",2500);
        product2=new Product(2,"ciao",800);
        mockMvc= MockMvcBuilders.standaloneSetup(productController).build();
    }

    @AfterEach
    public void tearDown(){
        productList=null;
        product=null;

    }

    @Test
    public void GetMappingOfAllProduct() throws Exception {
        when(productService.getAllProducts()).thenReturn(productList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(product))).andDo(MockMvcResultHandlers.print());
        verify(productService).getAllProducts();
        verify(productService, times(1)).getAllProducts();
    }


    @Test
    public void GetMappingOfProductShouldReturnRespectiveProduct() throws Exception {
        when(productService.getProductByid(1)).thenReturn(product);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/product/1").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(product))).andDo(MockMvcResultHandlers.print());
        verify(productService).getProductByid(1);
        verify(productService, times(1)).getProductByid(1);
    }

    /* GETBYID PROF, IDENTICA ALLA SUA DELETE
    when(productService.getProductByid(product.getId())).thenReturn(product);
        mockMvc.perform(get("/api/v1/product/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(product)))
                .andExpect(MockMvcResultMatchers.status()
                        .isOk())
                .andDo(MockMvcResultHandlers.print());
     */



    //ci vuole solo .isOk() al posto dei verify nella delete
    @Test
    public void DeleteMappingUrlAndIdThenShouldReturnDeletedProduct() throws Exception {
        when(productService.deleteProductById(2)).thenReturn(product2);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/product/2").contentType(MediaType.APPLICATION_JSON))
                        .andDo(MockMvcResultHandlers.print());
        verify(productService).deleteProductById(2);
        verify(productService, times(1)).deleteProductById(2);
    }








    //non vanno inseriti gli apici opposti ed il dollaro
    @Test
    public void GetMappingProduct2() throws Exception {
        int id=1;
        when(productService.getProductByid(id)).thenReturn(product);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/product/{id}",id).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(product))).andDo(MockMvcResultHandlers.print());
        verify(productService).getProductByid(id);
        verify(productService, times(1)).getProductByid(id);
    }




    @Test
    public void PostMappingOfProduct() throws Exception {
        Product product1= new Product(2,"Pluto",2500);
        when(productService.addProduct(any())).thenReturn(product1);
        when(productService.addProduct(any())).thenReturn(product1);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/product").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(product1))).andExpect(status().isCreated());
        verify(productService, times(1)).addProduct(any());
    }


    //metodo statico per trasformare gli oggett in JSon
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
