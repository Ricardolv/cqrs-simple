package com.richard.infrastructure.messaging.producer;

import com.richard.domain.dto.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Component
public class RegisterProductProducer {

    @Produce(value = "direct:register.product.producer")
    private ProducerTemplate producerTemplate;

    public void sendRegister(final Product product) {

        if (isNull(product))
            throw new IllegalArgumentException("Payload productSimple inválido.");

        log.info("{}.sendRegister() - INICIO product {} ", this.getClass().getName(), product);

        producerTemplate.asyncSendBody(producerTemplate.getDefaultEndpoint(), product) ;

        log.info("{}.sendRegister() - FIM product {} ", this.getClass().getName(), product);
    }

}
