package com.cafe_depot.cafe_depot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import java.util.Date;
import java.util.List;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long id;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @Column(name = "total", nullable = false)
    private Double total;

     // FK user_id
    @ManyToOne // Many orders can belong to one user
    @JoinColumn(name = "user_id") // Defines name of the foreign key column
    private UserEntity user;

    // an Order entity can have multiple OrderItem entities associated with it
    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> orderItems;

    public OrderEntity() {
    }

    public OrderEntity(UserEntity user, List<OrderItemEntity> orderItems, Date orderDate, double total) {
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", orderDate=" + orderDate + ", total=" + total + ", user=" + user + ", orderItems="
                + orderItems + "]";
    }

    
}
