package com.richard.infrastructure.persistence.mongo.entities;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class ProductMongoEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Long code;
    private String name;

}
