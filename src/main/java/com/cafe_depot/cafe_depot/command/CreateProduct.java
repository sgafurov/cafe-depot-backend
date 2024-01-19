package com.cafe_depot.cafe_depot.command;

import javax.validation.constraints.NotBlank;

public class CreateProduct {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private Double price;
    @NotBlank
    private Integer stock;
    @NotBlank
    private String category;
    @NotBlank
    private String imageNames;

    public CreateProduct() {
    }

    public CreateProduct(@NotBlank String name, @NotBlank String description, @NotBlank Double price,
            @NotBlank Integer stock, @NotBlank String category, @NotBlank String imageNames) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.imageNames = imageNames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getImageNames() {
        return imageNames;
    }

    public void setImageNames(String imageNames) {
        this.imageNames = imageNames;
    }
    

    @Override
    public String toString() {
        return "CreateProduct [name=" + name + ", description=" + description + ", price=" + price + ", stock=" + stock
                + ", category=" + category + ", imageNames=" + imageNames + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        CreateProduct other = (CreateProduct) obj;
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
