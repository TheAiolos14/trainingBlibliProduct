package com.example.product.controller;

import com.example.product.entity.Product;
import com.example.product.model.ApiKey;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService= productService;
    }

    @RequestMapping(
            value = "/products",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @RequestMapping(
            value = "/products/{idProduct}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public Product findById(@PathVariable("idProduct") String id){
        return productService.findById(id);
    }

    @RequestMapping(
            value = "/product",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ArrayList<Product> findAll(){
        return productService.findAll();
    }

    @RequestMapping(
            value = "/hello",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String hello(ApiKey apiKey){
        apiKey.getValue();
        return "Hello World";
    }
}
