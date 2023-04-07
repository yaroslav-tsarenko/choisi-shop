package com.shop.choisi.controller;

import com.shop.choisi.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    ArrayList<ProductDto> productDtos = new ArrayList<>();

    @GetMapping
    public List<ProductDto> getAll() {
        return productDtos;
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto dto) {
        productDtos.add(dto);
        return dto;
    }
}
