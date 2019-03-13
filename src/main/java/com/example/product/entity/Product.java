package com.example.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor //Constructor yang ada isinya
@NoArgsConstructor
@Entity
public class Product {

    @Id
    private String idProduct;

    private String nameProduct;
    private String idCategory;
}
