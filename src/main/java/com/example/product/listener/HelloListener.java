package com.example.product.listener;

import com.example.product.entity.Product;
import com.example.product.model.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j //buat pakai lombok
@Component
public class HelloListener {


    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "categories")
    public void listenTopicBelajar(String body) throws  Exception {
        Product product=  objectMapper.readValue(body, Product.class);
        log.info("Receive Message {}", product);
    }
}
