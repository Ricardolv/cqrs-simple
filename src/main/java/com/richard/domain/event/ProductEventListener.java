package com.richard.domain.event;

import com.richard.domain.dto.Product;
import com.richard.infrastructure.messaging.producer.RegisterProductProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductEventListener implements ApplicationListener<ProductEvent> {

    private final RegisterProductProducer registerProductProducer;

    @Async
    @Override
    public void onApplicationEvent(ProductEvent event) {
        Product product = event.getProduct();

        log.info("{}.onApplicationEvent() - INICIO product {} ", this.getClass().getName(), product);

        registerProductProducer.sendRegister(product);

        log.info("{}.onApplicationEvent() - INICIO product {} ", this.getClass().getName(), product);
    }
}
