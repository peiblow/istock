package com.veoow.istock.services;

import com.veoow.istock.enums.OrderStatus;
import com.veoow.istock.models.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderProcessService {
    public void receiveOrder(Order order) {
        System.out.println(Thread.currentThread().getName() + ": Recebendo pedido #" + order.getId());
        order.setStatus(OrderStatus.RECEIVED);
    }

    public void validateStock(Order order) {
        System.out.println(Thread.currentThread().getName() + ": Validando estoque para o pedido #" + order.getId());
        if (order.getProduct().getQuantity() > 0) {
            order.setStatus(OrderStatus.AVAILABLE);
        } else {
            order.setStatus(OrderStatus.UNAVAILABLE);
        }
    }

    public void paymentProcess(Order order) {
        System.out.println(Thread.currentThread().getName() + ": Processando pagamento para o pedido #" + order.getId());
        order.setStatus(OrderStatus.PAID);
    }

    public void updateDeliveredStatus(Order order) {
        System.out.println(Thread.currentThread().getName() + ": Atualizando status de entrega para o pedido #" + order.getId());
        order.setStatus(OrderStatus.DELIVERED);
    }
}
