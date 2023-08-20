package com.richard.infrastructure.persistence.jpa.repositories;

import com.richard.infrastructure.persistence.jpa.entities.ProductJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaEntityRepository extends JpaRepository<ProductJpaEntity, Long> {
}
