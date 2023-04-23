package com.shop.choisi.service;


import com.shop.choisi.dto.ProductDto;
import com.shop.choisi.entity.ProductEntity;
import com.shop.choisi.mapper.ProductEntityMapper;
import com.shop.choisi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductEntityMapper productEntityMapper;

    public List<ProductDto> loadAll() {
        List<ProductDto> productDtos = productEntityMapper.mapEntitiesToDto(productRepository.findAll());
        productDtos.sort(new SortProductsByAmount());
        return productDtos;
    }

    public ProductDto loadOne(Long id) {
        ProductEntity productEntity = productRepository.findProductById(id);
        return mapEntityToDto(productEntity);
    }

    private ProductDto mapEntityToDto(ProductEntity source) {
        ProductDto target = new ProductDto();
        target.setId(source.getId());
        target.setCreationDate(source.getCreationDate());
        target.setName(source.getName());
        target.setAmount(source.getAmount());
        target.setPrice(source.getPrice());
        target.setDiscount(source.getDiscount());
        target.setDescription(source.getDescription());
        return target;
    }


    public ProductEntity save(ProductEntity product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        ProductEntity productEntity = productRepository.findProductById(id);
        productRepository.delete(productEntity);
    }

    public ProductEntity update(ProductEntity newProduct) {
        ProductEntity oldProduct = productRepository.findProductById(newProduct.getId());
        boolean exists = Objects.nonNull(oldProduct);
        if (exists) {
            BeanUtils.copyProperties(newProduct, oldProduct);
            return save(oldProduct);
        } else {
            return save(newProduct);
        }
    }

    static class SortProductsByAmount implements Comparator<ProductDto>{
        @Override
        public int compare(ProductDto productDto,ProductDto productDto2){
            return productDto2.getAmount().compareTo(productDto.getAmount());
        }
    }
}
