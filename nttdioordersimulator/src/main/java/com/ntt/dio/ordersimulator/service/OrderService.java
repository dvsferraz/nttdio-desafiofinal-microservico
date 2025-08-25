package com.ntt.dio.ordersimulator.service;

import com.ntt.dio.ordersimulator.dto.OrderDTO;
import com.ntt.dio.ordersimulator.dto.OrderSimulateRequest;

public interface OrderService {

    OrderDTO simulate(OrderSimulateRequest request);
}