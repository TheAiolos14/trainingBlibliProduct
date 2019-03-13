package com.example.product;

import com.example.product.entity.Product;
import com.example.product.service.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class ProductServiceTest {


    ProductServiceImpl service = new ProductServiceImpl();

    @Test
    public void testCreate(){

        Product product = new Product("1", "Mobile Phone", "1");
        service.create(product);

        Assert.assertTrue("Total data harus 1", service.findAll().size() ==1);

        Product temp = service.findById("1");
        Assert.assertTrue("Category harus ada", product == temp);
    }

    @Test
    public void testFindById() {

        Product product= service.findById("kosong");
        Assert.assertTrue("Category harus null", product == null);

        service.create(new Product("1", "Sonyia","1"));
        service.findById("1");

        Assert.assertTrue("Harus ada Category", product != null);

    }

    @Test
    public void testFindAll(){

        service.create(new Product("1", "Mobile", "1"));
        service.create(new Product("2", "Fashion", "2"));
        Assert.assertTrue(service.findAll().size() == 2);


    }

    @Test
    public void testUpdate(){

        service.create(new Product("1", "Mobile", "1"));
        service.create(new Product("2", "Fashion", "2"));

        Product product= service.findById("1");
        Assert.assertTrue(product.getNameProduct().equals("Dua"));

        Assert.assertTrue("Harus ada Product", product != null);

    }

    @Test
    public  void testDelete(){

        service.create(new Product("1", "Mobile", "1"));
        service.create(new Product("2", "Fashion", "2"));

        Assert.assertTrue(service.findAll().size() == 2);

        service.delete("1");
        Assert.assertTrue(service.findAll().size() == 1);

        service.delete("2");
        Assert.assertTrue(service.findAll().size() == 0 );

    }


}
