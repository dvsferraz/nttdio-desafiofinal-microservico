package com.ntt.dio.ordersimulator.client;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {

    private String id;
    private String name;
    private String description;
    private Double price;
}
