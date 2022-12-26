package ru.gb.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.web.model.Product;
import ru.gb.web.service.ProductService;

import java.util.List;

@Controller
@RequestMapping
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/")
    public String getProducts(Model model) {
        List<Product> productList = productService.getAll();
        model.addAttribute("products", productList);
        return "index";
    }
}
