package com.cafe_depot.cafe_depot.controllers;

import org.slf4j.LoggerFactory;
import javax.validation.Valid;
import org.slf4j.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe_depot.cafe_depot.command.CreateProduct;
import com.cafe_depot.cafe_depot.entities.ProductEntity;
import com.cafe_depot.cafe_depot.models.ProductModel;
import com.cafe_depot.cafe_depot.services.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{category}")
    public List<ProductEntity> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductModel> addProduct(@RequestBody @Valid CreateProduct productCommand) {
        logger.info("addProduct request recieved with product: " + productCommand);
        ProductModel productModel = productService.addProduct(productCommand);
        logger.info("successfully created new product: " + productModel + " with id: " + productModel.getId());
        return new ResponseEntity<>(productModel, HttpStatus.OK);
    }

    // @PutMapping("update/{id}")
    // public SomeEnityData putMethodName(@PathVariable String id, @RequestBody
    // SomeEnityData entity) {
    // // TODO: process PUT request
    // return entity;
    // }

}
