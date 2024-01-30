package com.cafe_depot.cafe_depot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long id;

    // FK user_id
    @ManyToOne // Many orders can belong to one user
    @JoinColumn(name = "user_id") // Defines name of the foreign key column
    private UserEntity user;

    // an Order entity can have multiple OrderItem entities associated with it
    @OneToMany
    // (mappedBy = "order_id")
    private List<OrderItemEntity> orderItems;

    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    public OrderEntity() {
    }

    public OrderEntity(UserEntity user, Date orderDate, Double total) {
        this.user = user;
        this.orderDate = orderDate;
        this.total = total;
    }

    public OrderEntity(UserEntity user, List<OrderItemEntity> orderItems, Date orderDate, Double total) {
        this.user = user;
        this.orderItems = orderItems;
        this.orderDate = orderDate;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<OrderItemEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "OrderEntity [id=" + id + ", user=" + user + ", orderItems=" + orderItems + ", total=" + total
                + ", orderDate=" + orderDate + "]";
    }

}
