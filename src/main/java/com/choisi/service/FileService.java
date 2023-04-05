package com.choisi.service;


import com.choisi.dto.FileDto;
import com.choisi.entity.FileEntity;
import com.choisi.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    public List<FileEntity> loadAll() {
        return fileRepository.findAll();
    }

    public FileDto loadOne(Long id) {
        FileEntity fileEntity = fileRepository.findFileById(id);
        return mapEntityToDto(fileEntity);
    }

    private FileDto mapEntityToDto(FileEntity source) {
        FileDto target = new FileDto();
        target.setId(source.getId());
        target.setFileName(source.getFileName());
        target.setFileExtension(source.getFileExtension());
        target.setCreationDate(source.getCreationDate());
        target.setData(source.getFileData());
        return target;
    }

    public FileEntity save(FileEntity file) {
        return fileRepository.save(file);
    }

    public void delete(Long id) {
        FileEntity fileEntity = fileRepository.findFileById(id);
        fileRepository.delete(fileEntity);
    }

    public FileEntity update(FileEntity newFile) {
        FileEntity oldFile = fileRepository.findFileById(newFile.getId());
        boolean exists = Objects.nonNull(oldFile);
        if (exists) {
            BeanUtils.copyProperties(newFile, oldFile);
            return save(oldFile);
        } else {
            return save(newFile);
        }
    }
}
