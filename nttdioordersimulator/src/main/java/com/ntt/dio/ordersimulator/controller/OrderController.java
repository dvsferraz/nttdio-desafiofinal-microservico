package com.ntt.dio.ordersimulator.controller;

import com.ntt.dio.ordersimulator.client.ProductClient;
import com.ntt.dio.ordersimulator.dto.OrderDTO;
import com.ntt.dio.ordersimulator.dto.OrderSimulateRequest;
import com.ntt.dio.ordersimulator.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource(name = "orderService")
    private OrderService orderService;

    @PostMapping("/simulate")
    public ResponseEntity<OrderDTO> simulateOrder(@RequestBody OrderSimulateRequest orderRequest) {
        OrderDTO order = orderService.simulate(orderRequest);

        return ResponseEntity.ok(order);
    }
}