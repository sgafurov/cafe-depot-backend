package com.cafe_depot.cafe_depot.mapper;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cafe_depot.cafe_depot.command.CreateOrder;
import com.cafe_depot.cafe_depot.entities.OrderEntity;
import com.cafe_depot.cafe_depot.entities.OrderItemEntity;
import com.cafe_depot.cafe_depot.entities.UserEntity;
import com.cafe_depot.cafe_depot.models.OrderItemModel;
import com.cafe_depot.cafe_depot.models.OrderModel;

@Component
public class OrderMapper {

    private OrderItemMapper orderItemMapper;

    public OrderMapper(OrderItemMapper orderItemMapper) {
        this.orderItemMapper = orderItemMapper;
    }

    public OrderModel toModel(OrderEntity orderEntity) {
        List<OrderItemModel> items = orderEntity.getOrderItems().stream()
                .map(orderItem -> orderItemMapper.toModel(orderItem)).collect(Collectors.toList());
        return new OrderModel(orderEntity.getId(), orderEntity.getOrderDate(), orderEntity.getTotal(),
                orderEntity.getUser().getId(), items);
    }

    public OrderModel toModel(OrderEntity orderEntity, List<OrderItemEntity> orderItemEntities) {
        List<OrderItemModel> items = orderItemEntities.stream()
                .map(orderItem -> orderItemMapper.toModel(orderItem)).collect(Collectors.toList());
        return new OrderModel(orderEntity.getId(), orderEntity.getOrderDate(), orderEntity.getTotal(),
                orderEntity.getUser().getId(), items);
    }

    public OrderEntity toEntity(CreateOrder orderCommand, Double total) {
        return new OrderEntity(new UserEntity(orderCommand.getUserId()), new Date(), total);
    }
}