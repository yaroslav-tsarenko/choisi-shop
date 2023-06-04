package com.shop.choisi.mapper;

import com.shop.choisi.dto.ProductDto;
import com.shop.choisi.entity.ProductEntity;
import com.shop.choisi.util.DateTimeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

import static com.shop.choisi.util.DateTimeUtil.nowGMT0;
import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {

    @Test
    void mapDtoToEntity() {
        //Given
        ProductMapper productMapper = new ProductMapper();
        ProductDto productDto = createTestProduct();
        //When
        ProductEntity productEntity = productMapper.mapDtoToEntity(productDto);
        //Then
        Assertions.assertNotNull(productEntity);
        Assertions.assertEquals(productDto.getId(), productEntity.getId());
    }

    @Test
    void mapEntityToDto(){
        //Given
        ProductEntity testProductEntity = createTestProductEntity();
        ProductMapper productMapper = new ProductMapper();
        //When
        ProductDto productDto = productMapper.mapEntityToDto(testProductEntity);
        //Then
        Assertions.assertNotNull(productDto);
        Assertions.assertEquals(testProductEntity.getId(), productDto.getId());

    }

    @Test
    void mapEntityToDto_ifNull(){
        //Given
        ProductEntity testProductEntity = null;
        ProductMapper productMapper = new ProductMapper();
        //When
        ProductDto productDto = productMapper.mapEntityToDto(testProductEntity);
        //Then
        Assertions.assertNotNull(productDto);
    }

    public ProductDto createTestProduct(){
        ProductDto productDto = new ProductDto();
        productDto.setId(656L);
        productDto.setCreationDate(LocalDateTime.MAX);
        productDto.setName("John Doe");
        productDto.setAmount(454545L);
        productDto.setPrice(BigDecimal.valueOf(54545));
        productDto.setDiscount(String.valueOf(4545));
        productDto.setDescription("fflglgmfg");
        return productDto;
    }

    public ProductEntity createTestProductEntity() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(656L);
        productEntity.setCreationDate(Instant.now().toEpochMilli());
        productEntity.setName("John Doe");
        productEntity.setAmount(454545L);
        productEntity.setPrice(BigDecimal.valueOf(54545));
        productEntity.setDiscount(String.valueOf(4545));
        productEntity.setDescription("fflglgmfg");
        return productEntity;
    }
}