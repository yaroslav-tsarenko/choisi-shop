package com.shop.choisi.controller;


import com.shop.choisi.dto.FileDto;
import com.shop.choisi.entity.FileEntity;
import com.shop.choisi.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("files")
public class FileController {

    private final FileService fileService;

    @PostMapping
    public ResponseEntity<String> upload(@RequestParam("file")MultipartFile file){
        try{
            fileService.save(file);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(String.format("File uploaded successfully: %s", file.getOriginalFilename()));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(String.format("Could not upload the file: %s!", file.getOriginalFilename()));
        }
    }

  @GetMapping
    public List<FileDto> list(){
        return fileService.getAllFiles()
                .stream()
                .map(this::mapToFileDto)
                .collect(Collectors.toList());
  }

  private FileDto mapToFileDto(FileEntity fileEntity){
      String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
              .path("/files/")
              .path(String.valueOf(fileEntity.getId()))
              .toUriString();
        FileDto target = new FileDto();
        target.setId(fileEntity.getId());
        target.setName(fileEntity.getName());
        target.setCreationDate(String.valueOf(fileEntity.getCreationDate()));
        target.setExtension(fileEntity.getExtension());
        target.setType(fileEntity.getType());
        target.setSize(fileEntity.getSize());
        target.setUrl(downloadURL);

        return target;
  }

  @GetMapping("{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id){
      Optional<FileEntity> fileEntityOptional = fileService.getFileById(id);

      if(!fileEntityOptional.isPresent()){
          return ResponseEntity.notFound()
                  .build();
      }

      FileEntity fileEntity = fileEntityOptional.get();
      return ResponseEntity.ok()
              .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
              .contentType(MediaType.valueOf(fileEntity.getType()))
              .body(fileEntity.getData());
  }
}
