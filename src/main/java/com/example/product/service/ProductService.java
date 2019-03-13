package com.example.product.service;

import com.example.product.entity.Product;

import java.util.ArrayList;

public interface ProductService {

    Product create(Product product);

    Product findById(String idProduct);

    ArrayList<Product> findAll();

    Product update(Product product);

    Product delete(String idProduct);
}
