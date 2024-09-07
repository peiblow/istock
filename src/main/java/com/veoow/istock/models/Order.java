package com.veoow.istock.models;

import com.veoow.istock.enums.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import javax.validation.Valid;


@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @NotNull(message = "Order ID cannot be null")
    private Long id;

    @NotNull(message = "Client cannot be null")
    private Client client;

    @NotNull(message = "Product cannot be null")
    private Product product;

    @NotNull(message = "Status cannot be null")
    private OrderStatus status;
}
