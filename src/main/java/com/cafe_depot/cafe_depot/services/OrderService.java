package com.cafe_depot.cafe_depot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe_depot.cafe_depot.command.CreateOrder;
import com.cafe_depot.cafe_depot.entities.OrderEntity;
import com.cafe_depot.cafe_depot.entities.OrderItemEntity;
import com.cafe_depot.cafe_depot.entities.ProductEntity;
import com.cafe_depot.cafe_depot.mapper.OrderMapper;
import com.cafe_depot.cafe_depot.models.CartItemModel;
import com.cafe_depot.cafe_depot.models.OrderModel;
import com.cafe_depot.cafe_depot.repositories.OrderItemRepository;
import com.cafe_depot.cafe_depot.repositories.OrderRepository;
import com.cafe_depot.cafe_depot.repositories.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository,
            ProductRepository productRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
        this.orderMapper = orderMapper;
    }

    @Transactional
    public OrderModel createOrder(CreateOrder orderCommand) throws Exception {
        Double total = 0.0;

        List<OrderItemEntity> orderItems = new ArrayList<>();

        // fetch all the products in the list of order items
        Map<Long, CartItemModel> cartItemMap = orderCommand.getOrderItems().stream()
                .collect(Collectors.toMap(CartItemModel::getId, Function.identity()));

        // List<Long> productIds =
        // orderCommand.getOrderItems().stream().map(CartItemModel::getId).toList();
        List<ProductEntity> productEntities = productRepository.findAllById(cartItemMap.keySet().stream().toList());

        if (productEntities.size() != orderCommand.getOrderItems().size()) {
            throw new Exception("Invalid order items");
        }

        for (ProductEntity productEntity : productEntities) {
            CartItemModel cartItemModel = cartItemMap.get(productEntity.getId());
            if (productEntity.getStock() >= cartItemModel.getQuantity()) { // check if stock is valid
                productEntity.setStock(productEntity.getStock() - cartItemModel.getQuantity()); // update stock
                OrderItemEntity orderItem = new OrderItemEntity(productEntity, cartItemModel.getQuantity(),
                        productEntity.getPrice() * cartItemModel.getQuantity());
                total += orderItem.getSubtotal();
                orderItems.add(orderItem);
            } else {
                throw new Exception("Out of stock on " + productEntity.getName());
            }
        }

        OrderEntity orderEntity = orderMapper.toEntity(orderCommand, total);
        OrderEntity newEntity = orderRepository.save(orderEntity); // save order
        orderItems.forEach(orderItem -> {
            orderItem.setOrder(orderEntity); // update each order item with order entities
        });
        List<OrderItemEntity> savedEntities = orderItemRepository.saveAll(orderItems); // save the items
        // newEntity.setOrderItems(savedEntities);
        productRepository.saveAll(productEntities); // update the product with the stock being changed

        return orderMapper.toModel(newEntity, savedEntities);
    }
}
