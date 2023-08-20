package com.richard.domain;


import com.richard.domain.dto.Product;
import com.richard.infrastructure.persistence.mongo.entities.ProductMongoEntity;
import com.richard.infrastructure.persistence.mongo.repositories.ProductMongoEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductMongoService {

    private final ProductMongoEntityRepository productMongoEntityRepository;

    public void consumerProduct(final Product product) {
        log.info("{}.consumerProduct() - INICIO product {} ", this.getClass().getName(), product);

        ProductMongoEntity productMongoEntity = ProductMongoEntity.builder()
                .code(product.code())
                .name(product.name())
                .build();

        productMongoEntityRepository.save(productMongoEntity);

        log.info("{}.consumerProduct() - FIM productMongoEntity {} ", this.getClass().getName(), productMongoEntity);
    }

    public Page<ProductMongoEntity> findAll(Pageable pageable) {
        log.info("{}.findAll() - INICIO ", this.getClass().getName());

        Page<ProductMongoEntity> entities = productMongoEntityRepository.findAll(pageable);

        log.info("{}.findAll() - FIM ", this.getClass().getName());
        return entities;
    }
}
