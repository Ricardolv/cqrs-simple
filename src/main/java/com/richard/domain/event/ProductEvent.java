package com.richard.domain.event;

import com.richard.domain.dto.Product;
import java.io.Serial;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class ProductEvent extends ApplicationEvent {

    @Serial
    private static final long serialVersionUID = 6843411895555466831L;

    private final Product product;

    public ProductEvent(Object source, Product product) {
        super(source);
        this.product = product;
    }
}
