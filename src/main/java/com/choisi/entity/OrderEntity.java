package com.choisi.entity;

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

    @Column(name = "creation_date", columnDefinition = "DATE")
    private String creationDate;

    @Column(name = "comment", columnDefinition = "VARCHAR(255)")
    private String comment;

    @Column(name = "is_approved", columnDefinition = "BOOLEAN")
    private String isApproved;

    @Column(name = "is_canceled", columnDefinition = "BOOLEAN")
    private String isCanceled;



}
