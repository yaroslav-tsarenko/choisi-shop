package com.shop.choisi.mapper;


import com.shop.choisi.dto.ProductDto;
import com.shop.choisi.entity.ProductEntity;
import com.shop.choisi.util.DateTimeUtil;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.shop.choisi.util.DateTimeUtil.nowGMT0;

@Component
public class ProductMapper {

    public ProductEntity mapDtoToEntity(ProductDto source) {
        ProductEntity target = new ProductEntity();
        target.setId(source.getId());
        target.setCreationDate(nowGMT0());
        target.setName(source.getName());
        target.setAmount(nowGMT0());
        target.setPrice(source.getPrice());
        target.setDiscount(String.valueOf(nowGMT0()));
        target.setDescription(source.getDescription());
        return target;
    }

    public List<ProductEntity> mapDtosToEntities(List<ProductDto> source){
        return source.stream()
                .map(this::mapDtoToEntity)
                .collect(Collectors.toList());
    }

    public ProductDto mapEntityToDto(ProductEntity source) {
        ProductDto target = new ProductDto();
        target.setId(source.getId());
        target.setCreationDate(DateTimeUtil.utcToLocalDateTimeGMT3(source.getCreationDate()));
        target.setName(source.getName());
        target.setAmount(source.getAmount());
        target.setPrice(source.getPrice());
        target.setDiscount(source.getDiscount());
        target.setDescription(source.getDescription());
        return target;
    }

    public List<ProductDto> mapEntitiesToDtos(List<ProductEntity> source){
        return source.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
