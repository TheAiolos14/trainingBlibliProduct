package com.example.product.repository;

import com.example.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findAllById(String idProduct);
    List<Product> findAllByName(String nameProduct);
    //List<Product> save(Product product);

}
