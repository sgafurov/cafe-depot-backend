package com.cafe_depot.cafe_depot.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
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
    @JsonBackReference
    private OrderEntity order;

    // FK product_id
    @ManyToOne
    @JoinColumn(name = "product_id") // Defines name of the foreign key column
    private ProductEntity product;

    public OrderItemEntity() {
    }

    public OrderItemEntity(ProductEntity product, int quantity, double subtotal) {
        this.product = product;
        this.quantity = quantity;
        this.subtotal = subtotal;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderItem [id=" + id + ", subtotal=" + subtotal + ", quantity=" + quantity + ", order=" + order
                + ", product=" + product + "]";
    }

}
