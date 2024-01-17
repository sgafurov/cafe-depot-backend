package com.cafe_depot.cafe_depot.mapper;

import org.springframework.stereotype.Component;

import com.cafe_depot.cafe_depot.command.CreateProduct;
import com.cafe_depot.cafe_depot.entities.ProductEntity;
import com.cafe_depot.cafe_depot.models.ProductModel;

@Component
public class ProductMapper {
    public ProductModel toModel(ProductEntity productEntity) {
        return new ProductModel(productEntity.getId(), productEntity.getName(), productEntity.getDescription(),
                productEntity.getPrice(), productEntity.getStock(), productEntity.getCategory());
    }

    public ProductEntity toEntity(CreateProduct productCommand) {
        return new ProductEntity(productCommand.getName(), productCommand.getDescription(), productCommand.getPrice(),
                productCommand.getStock(), productCommand.getCategory());
    }
}
