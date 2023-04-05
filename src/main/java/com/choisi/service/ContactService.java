package com.choisi.service;

import com.choisi.dto.ContactDto;
import com.choisi.dto.UserDto;
import com.choisi.entity.ContactEntity;
import com.choisi.entity.UserEntity;
import com.choisi.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ContactService {

    private ContactRepository contactRepository;
    private final UserService userService;

    public List<ContactEntity> loadAll(){
        return contactRepository.findAll();
    }

    public ContactDto loadOne(Long id){
        ContactEntity contactEntity = contactRepository.findContactById(id);
        return mapEntityToDto(contactEntity);
    }

    private ContactDto mapEntityToDto(ContactEntity source){
        ContactDto target = new ContactDto();
        target.setId(source.getId());
        target.setUserId(source.getUserId());

        return target;
    }

    private UserDto mapEntityToDto(UserEntity source){
        UserDto target = new UserDto();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setPassword(source.getPassword());
        target.setRole(source.getRole());
        target.setAccountNonLocked(source.isAccountNonLocked());
        target.setCredentialsNonExpired(source.isCredentialsNonExpired());
        target.setEnabled(source.isEnabled());
        return target;
    }

    public ContactEntity save(ContactEntity contact){
        return contactRepository.save(contact);
    }

    public void delete(Long id){
        ContactEntity contactEntity = contactRepository.findContactById(id);
        contactRepository.delete(contactEntity);
    }

    public ContactEntity update(ContactEntity newContact){
        ContactEntity oldContact = contactRepository.findContactById(newContact.getId());
        boolean exists = Objects.nonNull(oldContact);
        if (exists){
            BeanUtils.copyProperties(newContact, oldContact);
            return save(oldContact);
        }else {
            return save(newContact);
        }
    }

    public void assign(Long contactId, Long userId){
        ContactEntity contactEntity = contactRepository.findContactById(contactId);
        UserEntity userEntity = userService.loadOne(userId);
        contactEntity.setUserId(userEntity);
        contactRepository.save(contactEntity);
    }

}
