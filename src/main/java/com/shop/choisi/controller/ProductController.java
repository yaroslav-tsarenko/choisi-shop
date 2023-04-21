package com.shop.choisi.controller;


import com.shop.choisi.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
  import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    ArrayList<ProductService> productServices = new ArrayList<>();

    @GetMapping
    public List<ProductService> getAll() {
        return productServices;
    }

    @PostMapping
    public ProductService save(@RequestBody ProductService dto) {
        productServices.add(dto);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    }

}
