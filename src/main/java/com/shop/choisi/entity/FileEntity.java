package com.shop.choisi.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "app_file")
public class FileEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_date")
    private Long creationDate;

    @Column(name = "extension")
    private String extension;

    @Column(name = "type")
    private String type;

    @Column(name = "size")
    private Long size;

    @Column(name = "url")
    private String url;

    @Column(name = "data", columnDefinition = "BYTEA")
    private byte[] data;

}
