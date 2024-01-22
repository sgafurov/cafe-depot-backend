package com.cafe_depot.cafe_depot.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe_depot.cafe_depot.entities.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findAll();

    Optional<ProductEntity> findById(Long id);

    List<ProductEntity> findByName(String name);

    List<ProductEntity> findByCategory(String category);

    void removeProductById(Long id);
}
