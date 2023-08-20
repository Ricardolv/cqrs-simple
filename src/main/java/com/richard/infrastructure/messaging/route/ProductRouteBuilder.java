package com.richard.infrastructure.messaging.route;


import com.richard.domain.ProductMongoService;
import com.richard.domain.dto.Product;
import com.richard.infrastructure.messaging.config.RabbitmqRegisterProductProperties;
import lombok.RequiredArgsConstructor;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductRouteBuilder extends RouteBuilder {
    private static final String CAMEL_RABBITMQ = "CamelRabbitmq";

    private final RabbitmqRegisterProductProperties rabbitmqRegisterProduct;
    private final ProductMongoService productMongoService;

    @Override
    public void configure() throws Exception {

        from("direct:register.product.producer")
                .setExchangePattern(ExchangePattern.InOnly)
                .routeId("register.product.producer")
                .marshal()
                .json(JsonLibrary.Gson, Product.class,true)
                .log("Send register product. Body: ${body}")
                .to(rabbitmqRegisterProduct.getEndpoint());

        from(rabbitmqRegisterProduct.getEndpoint())
                .routeId("register.product.consumer")
                .setExchangePattern(ExchangePattern.InOnly)
                .unmarshal()
                .json(JsonLibrary.Gson, Product.class, true)
                .bean(productMongoService, "consumerProduct")
                .removeHeaders(CAMEL_RABBITMQ)  //Limpando os headers Rabbitmq de consumo
                .end();

    }

}
