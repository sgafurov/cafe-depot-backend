package com.cafe_depot.cafe_depot.models;

public class ProductModel {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String category;
    private String imageNames;

    public ProductModel(Long id, String name, String description, Double price, Integer stock, String category,
            String imageNames) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.imageNames = imageNames;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }

    public String getImageNames() {
        return imageNames;
    }

    @Override
    public String toString() {
        return "ProductModel [id=" + id + ", name=" + name + ", description=" + description + ", price="
                + price + ", stock=" + stock + ", category=" + category + ", imageNames=" + imageNames + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((stock == null) ? 0 : stock.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((imageNames == null) ? 0 : imageNames.hashCode());
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
        ProductModel other = (ProductModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (stock == null) {
            if (other.stock != null)
                return false;
        } else if (!stock.equals(other.stock))
            return false;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        if (imageNames == null) {
            if (other.imageNames != null)
                return false;
        } else if (!imageNames.equals(other.imageNames))
            return false;
        return true;
    }

}
