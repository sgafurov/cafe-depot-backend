package com.cafe_depot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Order_Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_item_id;

    private double subtotal;
    private int quantity;

    //FK user_id
    @ManyToOne
    @JoinColumn(name = "user_id") // Defines name of the foreign key column
    private User user;

    //FK order_id
    @ManyToOne
    @JoinColumn(name = "order_id") // Defines name of the foreign key column
    private Order order;

    //FK product_id
    @ManyToOne
    @JoinColumn(name = "product_id") // Defines name of the foreign key column
    private Product product;
}
