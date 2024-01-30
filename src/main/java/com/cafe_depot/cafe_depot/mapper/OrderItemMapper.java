package com.cafe_depot.cafe_depot.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cafe_depot.cafe_depot.entities.OrderEntity;
import com.cafe_depot.cafe_depot.entities.OrderItemEntity;
import com.cafe_depot.cafe_depot.models.OrderItemModel;
import com.cafe_depot.cafe_depot.models.OrderModel;

@Component
public class OrderItemMapper {

    public OrderItemModel toModel(OrderItemEntity orderItemEntity) {
        return new OrderItemModel(orderItemEntity.getId(), orderItemEntity.getSubtotal(), orderItemEntity.getQuantity(),
                orderItemEntity.getProduct().getId());
    }
}
