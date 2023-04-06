package com.choisi.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto {

    private Long id;
    private String creationDate;
    private String name;
    private Long amount;
    private BigDecimal price;
    private String discount;
    private String description;
}
