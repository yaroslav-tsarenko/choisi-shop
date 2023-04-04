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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name", columnDefinition = "VARCHAR(255)")
    private String fileName;

    @Column(name = "file_extension", columnDefinition = "VARCHAR(255)")
    private String fileExtension;

    @Column(name = "creation_date", columnDefinition = "DATE")
    private String creationDate;

    @Column(name = "file_data", columnDefinition = "BYTEA")
    private String fileData;

}
