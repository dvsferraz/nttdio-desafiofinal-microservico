package com.ntt.dio.ordersimulator.dto;

import lombok.Getter;
import lombok.Setter;

import java.security.PrivateKey;
import java.util.List;

@Getter
@Setter
public class OrderDTO {

    private List<OrderEntryDTO> entries;

    private double totalPrice;
}