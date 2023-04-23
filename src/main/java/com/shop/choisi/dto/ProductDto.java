package com.shop.choisi.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private Long creationDate;
    private String name;
    private Long amount;
    private BigDecimal price;
    private String discount;
    private String description;
}
