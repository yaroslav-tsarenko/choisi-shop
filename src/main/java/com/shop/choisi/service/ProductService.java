package com.shop.choisi.service;


import com.shop.choisi.dto.ProductDto;
import com.shop.choisi.entity.ProductEntity;
import com.shop.choisi.mapper.ProductMapper;
import com.shop.choisi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDto> loadAll() {
        List<ProductEntity> productEntityList = productRepository.findAllSortedByAmount();
        return productMapper.mapEntitiesToDtos(productEntityList);
    }

    public ProductDto loadOne(Long id) {
        ProductEntity productEntity = productRepository.findProductById(id);
        return productMapper.mapEntityToDto(productEntity);
    }

    public ProductDto save(ProductDto product) {
        ProductEntity productEntity = productMapper.mapDtoToEntity(product);
        ProductEntity saved = productRepository.save(productEntity);
        return productMapper.mapEntityToDto(saved);
    }

    public void delete(Long id) {
        ProductEntity productEntity = productRepository.findProductById(id);
        productRepository.delete(productEntity);
    }

    public ProductEntity update(ProductDto product) {
        ProductEntity existing = productRepository.findProductById(product.getId());
        ProductEntity productEntity = productMapper.mapDtoToEntity(product);
        boolean exists = Objects.nonNull(existing);
        if (exists) {
            BeanUtils.copyProperties(productEntity, existing);
            return productRepository.save(existing);
        } else {
            return productRepository.save(productEntity);
        }
    }
}
