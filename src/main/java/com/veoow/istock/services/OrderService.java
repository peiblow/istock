package com.veoow.istock.services;

import com.veoow.istock.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class OrderService {

    @Autowired
    private OrderProcessService orderProcessService;

    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public void orderProcess(Order order) {
        executor.submit(() -> orderProcessService.receiveOrder(order));
        executor.submit(() -> orderProcessService.validateStock(order));
        executor.submit(() -> orderProcessService.paymentProcess(order));
        executor.submit(() -> orderProcessService.updateDeliveredStatus(order));
    }
}
