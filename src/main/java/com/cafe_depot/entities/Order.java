package com.cafe_depot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;
import java.util.Date;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @NotNull
    @Column(name = "order_date")
    private Date orderDate;

    @NotNull
    private double total;

     // FK user_id
    @ManyToOne // Many orders can belong to one user
    @JoinColumn(name = "user_id") // Defines name of the foreign key column
    private User user;

    // an Order entity can have multiple OrderItem entities associated with it
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

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

    protected Order() {
    }

    public Order(User user, List<OrderItem> orderItems, @NotNull Date orderDate, @NotNull double total) {
        this.user = user;
        this.orderItems = orderItems;
        this.orderDate = orderDate;
        this.total = total;
    }
}
