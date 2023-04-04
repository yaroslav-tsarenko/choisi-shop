package com.choisi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Long id;
    private String creationDate;
    private String name;
    private Long amount;
    private String price;
    private String discount;
    private String description;


}
