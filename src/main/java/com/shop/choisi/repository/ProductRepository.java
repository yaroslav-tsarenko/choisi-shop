package com.shop.choisi.repository;

import com.shop.choisi.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    ProductEntity findProductById(Long id);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM app_product as p ORDER BY p.amount DESC"
    )
    List<ProductEntity> findAllSortedByAmount();
}
