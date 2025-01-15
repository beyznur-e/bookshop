package com.example.bookstore.Entity;

import jakarta.persistence.*;
import org.hibernate.type.descriptor.jdbc.TimeWithTimeZoneJdbcType;

import java.time.ZonedDateTime;

@Entity
@Table(name = "order_book")
public class OrderE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) //İlişkili veriler gerektiğinde (lazy-loading) yüklenir.Bir sipariş nesnesine eriştiğinizde, kullanıcı bilgileri sadece ihtiyaç duyulduğunda yüklenir.
    @JoinColumn(name = "user_id")
    private UserE userE;

    @Column(name = "total_price")
    private Double total_price;

    @Column(name = "status")
    private String status;

    @Column(name = "order_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime order_date;

    public OrderE() {
    }

    public OrderE(Long id, UserE userE, Double total_price, String status, ZonedDateTime order_date) {
        this.id = id;
        this.userE = userE;
        this.total_price = total_price;
        this.status = status;
        this.order_date = order_date;
    }

    // Getter ve Setter metotları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserE getUserE() {
        return userE;
    }

    public void setUserE(UserE userE) {
        this.userE = userE;
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
