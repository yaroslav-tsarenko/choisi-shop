package com.choisi.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "app_file")
public class FileEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "extension")
    private String extension;

    @Column(name = "creation_date")
    private String creationDate;

    @Column(name = "file_data", columnDefinition = "BYTEA")
    private String fileData;

}
