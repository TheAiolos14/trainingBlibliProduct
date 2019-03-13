package com.example.product.service;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProductServiceImpl implements ProductService {

    private ArrayList<Product> list = new ArrayList<>();
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {

        list.add(product);
        return product;
    }

    @Override
    public Product findById(String id) {

        for(int i=0;i<list.size();i++){

            Product newProduct= list.get(i);
            if(id.compareTo(newProduct.getNameProduct()) == 0){
                return newProduct;
            }
            else{
                return null;
            }

        }

        return null;
    }

    @Override
    public ArrayList<Product> findAll() {
        return list;
    }

    @Override
    public Product update(Product product) {

        Product temp = findById(product.getNameProduct());

        if(temp == null){
            return  null;
        }

        BeanUtils.copyProperties(product, temp);
        return null;
    }

    @Override
    public Product delete(String id) {

        for(int i=0;i<list.size();i++){

            Product newProduct = list.get(i);

            if(id.compareTo(newProduct.getNameProduct()) == 0){

                list.remove(newProduct);

                return newProduct;
            }

        }
        return null;
    }

}
