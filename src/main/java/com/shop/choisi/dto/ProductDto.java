package com.shop.choisi.dto;

import com.shop.choisi.entity.ProductEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto extends ProductEntity {

    private Long id;
    private Long creationDate;
    private String name;
    private Long amount;
    private BigDecimal price;
    private String discount;
    private String description;
}
