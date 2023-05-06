package com.shop.choisi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileDto {

    private Long id;
    private String name;
    private String creationDate;
    private String extension;
    private String type;
    private Long size;
    private String url;
    private Byte[] data;
}
