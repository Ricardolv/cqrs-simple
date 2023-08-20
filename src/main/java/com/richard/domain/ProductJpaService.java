package com.richard.domain;


import com.richard.domain.dto.Product;
import com.richard.domain.event.ProductEvent;
import com.richard.infrastructure.persistence.jpa.entities.ProductJpaEntity;
import com.richard.infrastructure.persistence.jpa.repositories.ProductJpaEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductJpaService {

    private final ProductJpaEntityRepository productJpaEntityRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public void save(ProductJpaEntity productJpa) {
        log.info("{}.save() - INICIO productJpa {} ", this.getClass().getName(), productJpa);

        productJpaEntityRepository.save(productJpa);

        Product product = new Product(productJpa.getCode(), productJpa.getName());

        applicationEventPublisher.publishEvent(new ProductEvent(this, product));

        log.info("{}.save() - FIM productJpa {} ", this.getClass().getName(), productJpa);
    }

}
