package ru.gb.products.service;

import ru.gb.products.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProduct(long id);

    void sendMessage(Product product);
}
