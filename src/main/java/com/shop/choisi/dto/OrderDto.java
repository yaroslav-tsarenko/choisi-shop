package com.shop.choisi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

    private Long id;
    private Long creationDate;
    private String comment;
    private Boolean isApproved;
    private Boolean isCanceled;


}
