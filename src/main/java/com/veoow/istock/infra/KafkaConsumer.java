package com.veoow.istock.infra;

import com.veoow.istock.models.Order;
import com.veoow.istock.services.OrderService;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class KafkaConsumer {

    @Autowired
    private OrderService orderService;

    @KafkaListener(topics = "order", groupId = "istock")
    public void consume(Order order) {
        validateOrder(order);
        orderService.orderProcess(order);
    }

    private void validateOrder(Order order) {
        if (order.getId() == null ||
                order.getClient() == null ||
                order.getProduct() == null ||
                order.getStatus() == null) {
            throw new IllegalArgumentException("Order contains null fields and cannot be processed.");
        }
    }
}
