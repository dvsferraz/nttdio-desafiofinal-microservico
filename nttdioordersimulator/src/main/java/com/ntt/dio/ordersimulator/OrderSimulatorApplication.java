package com.ntt.dio.ordersimulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderSimulatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderSimulatorApplication.class, args);
    }
}