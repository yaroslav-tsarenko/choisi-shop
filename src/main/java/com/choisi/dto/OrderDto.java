package com.choisi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    private Long id;
    private String creationDate;
    private String comment;
    private String isApproved;
    private String isCanceled;


}
