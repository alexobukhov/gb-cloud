package ru.gb.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gb.web.model.Product;
import ru.gb.web.model.ProductList;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    RestTemplate restTemplate;

    private final String URL = "https://localhost:8080/products/get";

    public List<Product> getAll() {
        ProductList response = restTemplate.getForObject(URL, ProductList.class);
        List<Product> products = response.getProducts();
        return products;
    }
}
