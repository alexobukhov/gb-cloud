package ru.gb.gbcart.consumer;

import com.google.gson.Gson;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ru.gb.gbcart.model.Product;

@Component
public class Consumer {

    @JmsListener(destination = "${spring.activemq.broker-cart-queue-in}")
    public Product consumeMessage(String message) {
        return new Gson().fromJson(message, Product.class);
    }
}