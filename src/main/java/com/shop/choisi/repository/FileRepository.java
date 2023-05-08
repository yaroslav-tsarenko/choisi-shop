package com.shop.choisi.repository;


import com.shop.choisi.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, String> {

    FileEntity findFileEntityById(String id);
}
