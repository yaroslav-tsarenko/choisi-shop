package com.choisi.repository;

import com.choisi.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
   FileEntity findFileById(Long id);
}
