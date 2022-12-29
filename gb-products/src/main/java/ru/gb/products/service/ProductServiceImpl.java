package ru.gb.products.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.products.model.Product;
import ru.gb.products.producer.Producer;
import ru.gb.products.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Producer producer;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void sendMessage(Product product) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        producer.sendMessage(gson.toJson(product));
    }
}
