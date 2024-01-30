package com.cafe_depot.cafe_depot.models;

public class CartItemModel {
    private Long id;
    private int quantity;

    public CartItemModel() {

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

    @Override
    public String toString() {
        return "CartItemsModel [id=" + id + ", quantity=" + quantity + "]";
    }

}
