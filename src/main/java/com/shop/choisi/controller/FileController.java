package com.shop.choisi.controller;


import com.shop.choisi.dto.FileDto;
import com.shop.choisi.service.FileService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;

    @PostMapping("/file")
    public ResponseEntity<String> upload(@RequestPart(name = "file") MultipartFile file, HttpServletRequest request) {

        try {
            String save = fileService.save(file);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(String.format("File uploaded successfully: %s", save));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(String.format("Could not upload the file: %s!", file.getOriginalFilename()));
        }
    }
//
//    @GetMapping
//    public List<FileDto> list() {
//        return fileService.getAllFiles()
//                .stream()
//                .map(this::mapToFileDto)
//                .collect(Collectors.toList());
//    }

    @GetMapping("{id}")
    public ResponseEntity<byte[]> loadById(@PathVariable String id) {
        FileDto fileDto = fileService.loadById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDto.getName()+"."+fileDto.getExtension() + "\"")
                .contentType(MediaType.valueOf(fileDto.getType()))
                .body(fileDto.getData());
    }
}
