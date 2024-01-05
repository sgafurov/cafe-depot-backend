package com.cafe_depot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.util.Date;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;
    private Date order_date;
    private double total;

    //FK user_id
    @ManyToOne
    @JoinColumn(name = "user_id") // Defines name of the foreign key column
    private User user;
}
