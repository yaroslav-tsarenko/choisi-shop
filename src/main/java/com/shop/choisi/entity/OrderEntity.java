package com.shop.choisi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "app_order")
public class OrderEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_date")
    private Long creationDate;

    @Column(name = "comment")
    private String comment;

    @Column(name = "is_approved")
    private Boolean isApproved;

    @Column(name = "is_canceled")
    private Boolean isCanceled;



}
