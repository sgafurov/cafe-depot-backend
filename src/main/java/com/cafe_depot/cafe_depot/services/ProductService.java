package com.cafe_depot.cafe_depot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe_depot.cafe_depot.command.CreateProduct;
import com.cafe_depot.cafe_depot.entities.ProductEntity;
import com.cafe_depot.cafe_depot.mapper.ProductMapper;
import com.cafe_depot.cafe_depot.models.ProductModel;
import com.cafe_depot.cafe_depot.repositories.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductModel addProduct(CreateProduct productCommand) {
        // create new product
        ProductEntity productEntity = productMapper.toEntity(productCommand);
        ProductEntity newProduct = productRepository.save(productEntity); // saves to the db
        ProductModel productModel = productMapper.toModel(newProduct); // creates a new model to return to client
        return productModel;
    }

    // public ProductEntity updateProduct() {
    //     // make sure the product exists first. then update the product (either name,
    //     // desc, price, stock)
    // }

}
