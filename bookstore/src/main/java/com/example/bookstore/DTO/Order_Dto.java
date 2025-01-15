package com.example.bookstore.DTO;

import com.example.bookstore.Entity.OrderE;
import org.hibernate.type.descriptor.jdbc.TimeWithTimeZoneJdbcType;

import java.time.ZonedDateTime;

public class Order_Dto {
    private Long id;
    private Long user_id;
    private Double total_price;
    private String status;
    private ZonedDateTime order_date;

    public Order_Dto() {
    }

    public Order_Dto(Long id, Long user_id, Double total_price, String status, ZonedDateTime order_date) {
        this.id = id;
        this.user_id = user_id;
        this.total_price = total_price;
        this.status = status;
        this.order_date = order_date;
    }

    // fromEntity metodu
    public static Order_Dto fromEntity(OrderE orderE) {
        return new Order_Dto(
                orderE.getId(),
                orderE.getUserE() != null ? orderE.getUserE().getId() : null, // UserE içindeki id alınır
                orderE.getTotal_price(),
                orderE.getStatus(),
                orderE.getOrder_date()
        );
    }

    // Getter ve Setter metotları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ZonedDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(ZonedDateTime order_date) {
        this.order_date = order_date;
    }
}
