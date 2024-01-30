package com.cafe_depot.cafe_depot.models;

public class OrderItemModel {
    private Long id;
    private Double subtotal;
    private Integer quantity;
    private Long productId;

    public OrderItemModel(Long id, Double subtotal, Integer quantity, Long productId) {
        this.id = id;
        this.subtotal = subtotal;
        this.quantity = quantity;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Long getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return "OrderItemModel [id=" + id + ", subtotal=" + subtotal + ", quantity=" + quantity + ", productId="
                + productId + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((subtotal == null) ? 0 : subtotal.hashCode());
        result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
        OrderItemModel other = (OrderItemModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (subtotal == null) {
            if (other.subtotal != null)
                return false;
        } else if (!subtotal.equals(other.subtotal))
            return false;
        if (quantity == null) {
            if (other.quantity != null)
                return false;
        } else if (!quantity.equals(other.quantity))
            return false;
        if (productId == null) {
            if (other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;
        return true;
    }

}
