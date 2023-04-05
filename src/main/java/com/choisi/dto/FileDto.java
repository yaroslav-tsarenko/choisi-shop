package com.choisi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileDto {

    private Long id;
    private String fileName;
    private String fileExtension;
    private String creationDate;
    private String data;
}
