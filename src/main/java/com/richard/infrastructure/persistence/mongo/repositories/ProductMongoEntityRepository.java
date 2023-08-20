package com.richard.infrastructure.persistence.mongo.repositories;

import com.richard.infrastructure.persistence.mongo.entities.ProductMongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductMongoEntityRepository extends MongoRepository<ProductMongoEntity, Long> {
}
