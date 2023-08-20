package com.richard.infrastructure.resources;

import com.richard.domain.ProductMongoService;
import com.richard.infrastructure.resources.mapper.ProductMapper;
import com.richard.infrastructure.resources.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/query/products")
public class ProductQueryResource {

    private final ProductMongoService productMongoService;
    private final ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> findAll(Pageable pageable) {
        log.info("{}.findAll() - INICIO ", this.getClass().getName());

        Page<ProductResponse> responses = productMongoService.findAll(pageable).map(productMapper::entityToResponse);

        log.info("{}.findAll() - FIM ", this.getClass().getName());
        return ResponseEntity.ok(responses);
    }

}
