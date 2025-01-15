package com.example.bookstore.Controller;

import com.example.bookstore.Business.Service.OrderService;
import com.example.bookstore.DTO.Order_Dto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<Order_Dto> createOrder(@RequestBody Order_Dto order_dto) {
        Order_Dto createdOrder = orderService.createOrder(order_dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Order_Dto>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order_Dto> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order_Dto> updateOrder(@PathVariable Long id, @RequestBody Order_Dto order_dto) {
        return ResponseEntity.ok(orderService.updateOrder(id, order_dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
