package com.example.bookstore.Business;

import com.example.bookstore.DTO.Order_Dto;
import com.example.bookstore.Entity.OrderE;

import java.util.List;

public interface OrderI {
    Order_Dto createOrder(Order_Dto order_dto);
    List<Order_Dto> getAllOrders();
    Order_Dto getOrderById(Long id);
    Order_Dto updateOrder(Long id, Order_Dto orderDto);
    void  deleteOrder(Long id);
}
