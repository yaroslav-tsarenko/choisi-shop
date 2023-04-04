package com.choisi.repository;

import com.choisi.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
    ContactEntity findContactById(Long id);
}
