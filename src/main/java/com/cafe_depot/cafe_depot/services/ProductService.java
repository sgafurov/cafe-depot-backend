package com.cafe_depot.cafe_depot.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe_depot.cafe_depot.command.CreateProduct;
import com.cafe_depot.cafe_depot.entities.ProductEntity;
import com.cafe_depot.cafe_depot.mapper.ProductMapper;
import com.cafe_depot.cafe_depot.models.ProductModel;
import com.cafe_depot.cafe_depot.repositories.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductModel getProductById(Long productId) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(productId);
        ProductEntity productEntity = optionalProductEntity
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
        ProductModel productModel = productMapper.toModel(productEntity);
        return productModel;
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public List<ProductEntity> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<ProductEntity> getProductsByKeyword(String keyword) {
        List<ProductEntity> allProducts = productRepository.findAll();
        List<ProductEntity> filteredProducts = allProducts.stream()
                .filter(product -> product.getDescription().toLowerCase().contains(keyword.toLowerCase()) ||
                        product.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        return filteredProducts;
        // productEntities.removeIf(product ->
        // !product.getDescription().toLowerCase().contains(keyword.toLowerCase()));
        // productEntities.removeIf(product ->
        // !product.getName().toLowerCase().contains(keyword.toLowerCase()));
        // return productEntities;
    }

    public ProductModel addProduct(CreateProduct productCommand) {
        // create new product
        ProductEntity productEntity = productMapper.toEntity(productCommand);
        ProductEntity newProduct = productRepository.save(productEntity); // saves to the db
        ProductModel productModel = productMapper.toModel(newProduct); // creates a new model to return to client
        return productModel;
    }

    @Transactional
    public boolean removeProduct(Long id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.removeProductById(id);
            return true;
        }
        return false;
    }
    // public ProductEntity updateProduct() {
    // // make sure the product exists first. then update the product (either name,
    // // desc, price, stock)
    // }

}
