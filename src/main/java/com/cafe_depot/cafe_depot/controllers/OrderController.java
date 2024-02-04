package com.cafe_depot.cafe_depot.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe_depot.cafe_depot.command.CreateOrder;
import com.cafe_depot.cafe_depot.entities.OrderEntity;
import com.cafe_depot.cafe_depot.models.OrderModel;
import com.cafe_depot.cafe_depot.services.OrderService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // @GetMapping
    // public ResponseEntity<List<OrderEntity>> getAllOrders() {
    // List<OrderEntity> orders = orderService.getAllOrders();
    // return new ResponseEntity<>(orders, HttpStatus.OK);
    // }

    // @GetMapping("/{orderId}")
    // public ResponseEntity<OrderEntity> getOrderById(@PathVariable Long orderId) {
    // OrderEntity order = orderService.getOrderById(orderId);
    // return new ResponseEntity<>(order, HttpStatus.OK);
    // }

    @GetMapping("/{userId}")
    public List<OrderEntity> getOrdersByUserId(@PathVariable Long userId) {
        logger.info("getOrdersByUserId request recieved with userId: " + userId);
        return orderService.getOrdersByUserId(userId);
    }

    @PostMapping // creates new order
    public ResponseEntity<OrderModel> createOrder(@RequestBody @Valid CreateOrder orderCommand) throws Exception {
        logger.info("createOrder request recieved with order: " + orderCommand);
        OrderModel orderModel = orderService.createOrder(orderCommand);
        logger.info("successfully created new order: " + orderModel);
        return new ResponseEntity<>(orderModel, HttpStatus.OK);
    }

}