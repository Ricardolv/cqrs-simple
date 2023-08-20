package com.richard.infrastructure.resources;

import com.richard.domain.ProductJpaService;
import com.richard.infrastructure.persistence.jpa.entities.ProductJpaEntity;
import com.richard.infrastructure.resources.request.ProductRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/command/products")
public class ProductCommandResource {

    private final ProductJpaService productJpaService;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody ProductRequest productRequest) {
        log.info("{}.create() - INICIO productRequest {} ", this.getClass().getName(), productRequest);

        ProductJpaEntity productJpa = ProductJpaEntity
                .builder()
                .name(productRequest.name())
                .build();

        productJpaService.save(productJpa);

        log.info("{}.create() - FIM productJpa {} ", this.getClass().getName(), productJpa);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }



    }
