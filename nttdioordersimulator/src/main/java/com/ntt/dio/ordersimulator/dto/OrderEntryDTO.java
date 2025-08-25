package com.ntt.dio.ordersimulator.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderEntryDTO {
    private String name;
    private double pricePerUnit;
    private double totalPrice;
    private String productId;
    private int quantity;
}
