package com.shop.choisi.controller;


import com.shop.choisi.dto.ProductDto;
import com.shop.choisi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getAll() {
        return productService.loadAll();
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto dto) {
        return productService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

}
