package com.shop.choisi.controller;


import com.shop.choisi.dto.ProductDto;
import com.shop.choisi.entity.ProductEntity;
import com.shop.choisi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public List<ProductEntity> getAll() {
        return productService.loadAll();
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto dto) {
        productService.save(dto);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    }

}
