package com.cafe_depot.cafe_depot.models;

import java.util.Date;
import java.util.List;

public class OrderModel {
    private Long id;
    private Date orderDate;
    private Double total;
    private Long userId;
    private List<OrderItemModel> orderItems;

    public OrderModel(Long id) {
        this.id = id;
    }

    public OrderModel(Long id, Date orderDate, Double total, Long userId, List<OrderItemModel> orderItems) {
        this.id = id;
        this.orderDate = orderDate;
        this.total = total;
        this.userId = userId;
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Double getTotal() {
        return total;
    }

    public Long getUserId() {
        return userId;
    }

    public List<OrderItemModel> getOrderItemIds() {
        return orderItems;
    }

    @Override
    public String toString() {
        return "OrderModel [id=" + id + ", orderDate=" + orderDate + ", total=" + total + ", userId=" + userId
                + ", orderItemIds=" + orderItems + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
        result = prime * result + ((total == null) ? 0 : total.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        result = prime * result + ((orderItems == null) ? 0 : orderItems.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderModel other = (OrderModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (orderDate == null) {
            if (other.orderDate != null)
                return false;
        } else if (!orderDate.equals(other.orderDate))
            return false;
        if (total == null) {
            if (other.total != null)
                return false;
        } else if (!total.equals(other.total))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        if (orderItems == null) {
            if (other.orderItems != null)
                return false;
        } else if (!orderItems.equals(other.orderItems))
            return false;
        return true;
    }

}
