package com.shop.choisi.service;


import com.shop.choisi.dto.FileDto;
import com.shop.choisi.entity.FileEntity;
import com.shop.choisi.exception.ChoisiNotFoundException;
import com.shop.choisi.repository.FileRepository;
import com.shop.choisi.util.Constants;
import com.shop.choisi.util.DateTimeUtil;
import jakarta.servlet.ServletContext;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class FileService {
    private final Environment environment;
    private final FileRepository fileRepository;

    public String save(MultipartFile multipartFile) throws IOException {
        String storagePath = createStoragePath();
        String fileId = UUID.randomUUID().toString();
        String originalFilename = multipartFile.getOriginalFilename();
        String[] nameParts = Objects.requireNonNull(originalFilename).split("\\.");
        String fileName = nameParts[0];
        String fileExtension = nameParts[1];
        File file = new File(storagePath + File.separator + fileId + "." + fileExtension);
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.flush();
        stream.close();

        FileEntity fileEntity = new FileEntity();
        fileEntity.setId(fileId);
        fileEntity.setName(fileName);
        fileEntity.setCreationDate(DateTimeUtil.nowGMT0());
        fileEntity.setExtension(fileExtension);
        fileEntity.setType(multipartFile.getContentType());
        fileEntity.setSize(multipartFile.getSize());

        FileEntity saved = fileRepository.save(fileEntity);
        return saved.getId();
    }

    public FileDto loadById(String id) {
        FileEntity fileEntityById = fileRepository.findFileEntityById(id);
        if (isNull(fileEntityById)) {
            throw new ChoisiNotFoundException("File not exists");
        }
        return mapToFileDto(fileEntityById);
    }

    private FileDto mapToFileDto(FileEntity fileEntity) {

        FileDto target = new FileDto();
        target.setId(fileEntity.getId());
        target.setName(fileEntity.getName());
        target.setCreationDate(String.valueOf(fileEntity.getCreationDate()));
        target.setExtension(fileEntity.getExtension());
        target.setType(fileEntity.getType());
        target.setSize(fileEntity.getSize());

        try {
            String storagePath = createStoragePath();
            String absoluteFilePath = storagePath + File.separator + target.getId() + "." + target.getExtension();
            File file = new File(absoluteFilePath);
            FileInputStream stream = new FileInputStream(file);
            byte[] bytes = stream.readAllBytes();
            target.setData(bytes);
            stream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return target;
    }

    public List<FileEntity> getAllFiles() {
        return fileRepository.findAll();
    }

    private String createStoragePath() throws IOException {
        String path = System.getProperty("user.dir");
        String folder = environment.getProperty(Constants.FILE_STORAGE_FOLDER);
        String storagePath = path + File.separator + folder;
        Files.createDirectories(Path.of(storagePath));
        return storagePath;
    }
}
