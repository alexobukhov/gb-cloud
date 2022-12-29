package ru.gb.products.service;

import ru.gb.products.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    void sendMessage(Product product);
}
