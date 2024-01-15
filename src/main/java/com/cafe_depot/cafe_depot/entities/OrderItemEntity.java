package com.cafe_depot.cafe_depot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "order_item")
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id", nullable = false)
    private Long id;

    @Column(name = "subtotal", nullable = false)
    private Double subtotal;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    // FK order_id
    // specifies the foreign key column in the OrderItem table that corresponds to
    // the primary key (order_id) of the Order table.
    @ManyToOne
    @JoinColumn(name = "order_id") // Defines name of the foreign key column
    private OrderEntity order;

    // FK product_id
    @ManyToOne
    @JoinColumn(name = "product_id") // Defines name of the foreign key column
    private ProductEntity product;

    public OrderItemEntity() {
    }

    public OrderItemEntity(OrderEntity order, ProductEntity product, int quantity, double subtotal) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem [id=" + id + ", subtotal=" + subtotal + ", quantity=" + quantity + ", order=" + order
                + ", product=" + product + "]";
    }

    
}
