package com.choisi.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "app_product")
public class ProductEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_date", columnDefinition = "DATE")
    private String creationDate;

    @Column(name = "name", columnDefinition = "VARCHAR(255)")
    private String name;

    @Column(name = "amount", columnDefinition = "BIGINT")
    private Long amount;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "discount", columnDefinition = "VARCHAR(255)")
    private String discount;

    @Column(name = "description", columnDefinition = "VARCHAR(255)")
    private String description;


}
