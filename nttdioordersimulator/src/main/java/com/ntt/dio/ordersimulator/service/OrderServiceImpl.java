package com.ntt.dio.ordersimulator.service;

import com.ntt.dio.ordersimulator.client.ProductClient;
import com.ntt.dio.ordersimulator.dto.ItemResquest;
import com.ntt.dio.ordersimulator.dto.OrderDTO;
import com.ntt.dio.ordersimulator.dto.OrderEntryDTO;
import com.ntt.dio.ordersimulator.dto.OrderSimulateRequest;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource
    private ProductClient productClient;


    @Override
    public OrderDTO simulate(OrderSimulateRequest request) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setEntries(new ArrayList<>());

        var totalPrice = 0.0;

        for(ItemResquest item : request.getItems()){
            var product = productClient.getProduct(item.getProductId());
            if(product != null){
                OrderEntryDTO orderEntryDTO = new OrderEntryDTO();
                orderEntryDTO.setName(product.getName());
                orderEntryDTO.setPricePerUnit(product.getPrice());
                orderEntryDTO.setTotalPrice(product.getPrice() * item.getQuantity());
                orderEntryDTO.setProductId(product.getId());
                orderEntryDTO.setQuantity(item.getQuantity());

                orderDTO.getEntries().add(orderEntryDTO);
                totalPrice += orderEntryDTO.getTotalPrice();

            } else {
                throw new RuntimeException("Product not found: " + item.getProductId());
            }
        }

        orderDTO.setTotalPrice(totalPrice);
        return orderDTO;

    }
}