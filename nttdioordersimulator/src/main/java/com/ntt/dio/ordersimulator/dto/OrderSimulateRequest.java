package com.ntt.dio.ordersimulator.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderSimulateRequest {

    private List<ItemResquest> items;

}
