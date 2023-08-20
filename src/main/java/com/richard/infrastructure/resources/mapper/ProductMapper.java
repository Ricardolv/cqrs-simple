package com.richard.infrastructure.resources.mapper;

import com.richard.infrastructure.persistence.jpa.entities.ProductJpaEntity;
import com.richard.infrastructure.persistence.mongo.entities.ProductMongoEntity;
import com.richard.infrastructure.resources.response.ProductResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductResponse entityToResponse(ProductJpaEntity entity);

    ProductResponse entityToResponse(ProductMongoEntity entity);
    ProductJpaEntity reponseToEntity(ProductResponse response);


}
