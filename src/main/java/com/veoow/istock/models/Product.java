package com.veoow.istock.models;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private int quantity;
}
