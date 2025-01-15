package com.example.bookstore.Business.Service;

import com.example.bookstore.Business.OrderI;
import com.example.bookstore.DTO.Order_Dto;
import com.example.bookstore.Entity.OrderE;
import com.example.bookstore.Entity.Repository.OrderRepository;
import com.example.bookstore.Entity.Repository.UserRepository;
import com.example.bookstore.Entity.UserE;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService implements OrderI {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Order_Dto createOrder(Order_Dto order_dto) {
        UserE userE = userRepository.findById(order_dto.getUser_id())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı: " + order_dto.getUser_id()));

        OrderE orderE = new OrderE();
        orderE.setUserE(userE);
        orderE.setTotal_price(order_dto.getTotal_price());
        orderE.setStatus(order_dto.getStatus());
        orderE.setOrder_date(ZonedDateTime.now());

        OrderE savedOrder = orderRepository.save(orderE);
        return Order_Dto.fromEntity(savedOrder);
    }

    @Override
    public List<Order_Dto> getAllOrders() {
        List<OrderE> orders = orderRepository.findAll();
        return orders.stream().map(Order_Dto::fromEntity).collect(Collectors.toList()); //Her Order nesnesini bir Order_Dto nesnesine dönüştürür ve listede toplar.
    }

    @Override
    public Order_Dto getOrderById(Long id) {
        OrderE orderE = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sipariş bulunamadı: " + id));
        return Order_Dto.fromEntity(orderE);
    }

    @Override
    public Order_Dto updateOrder(Long id, Order_Dto order_dto) {
        OrderE orderE = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sipariş bulunamadı: " + id));

        orderE.setTotal_price(order_dto.getTotal_price());
        orderE.setStatus(order_dto.getStatus());
        orderE.setOrder_date(order_dto.getOrder_date() != null
                ? order_dto.getOrder_date()
                : orderE.getOrder_date());

        OrderE updatedOrder = orderRepository.save(orderE);
        return Order_Dto.fromEntity(updatedOrder);    }

    @Override
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Sipariş bulunamadı: " + id);
        }
        orderRepository.deleteById(id);
    }
}
