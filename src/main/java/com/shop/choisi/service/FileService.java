package com.shop.choisi.service;


import com.shop.choisi.entity.FileEntity;
import com.shop.choisi.repository.FileRepository;
import com.shop.choisi.util.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

  public void save(MultipartFile file) throws IOException{
      FileEntity fileEntity = new FileEntity();
      fileEntity.setName(StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename())));
      fileEntity.setCreationDate(DateTimeUtil.nowGMT0());
      fileEntity.setExtension(file.getInputStream().toString());
      fileEntity.setType(file.getContentType());
      fileEntity.setData(file.getBytes());
      fileEntity.setSize(file.getSize());

      fileRepository.save(fileEntity);

  }

  public Optional<FileEntity> getFileById(String id){
      return fileRepository.findById(id);
  }

  public List<FileEntity> getAllFiles(){
      return fileRepository.findAll();
  }



}
