package ru.gb.products.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    public String sendMessage(String outMessage) {
        try {
            jmsTemplate.convertAndSend(queue, outMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outMessage;
    }
}
