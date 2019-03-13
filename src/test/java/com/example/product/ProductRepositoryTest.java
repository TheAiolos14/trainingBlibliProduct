package com.example.product;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    private Product product;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindAll() {

        //categoryRepository.deleteAll().block();

        productRepository.save(new Product("1", "Handphone", "1"));

        productRepository.save(new Product("2", "Laptop", "2"));

        List<Product> product= productRepository.findAll();

        Assert.assertTrue(product.size() == 2);
    }
}
