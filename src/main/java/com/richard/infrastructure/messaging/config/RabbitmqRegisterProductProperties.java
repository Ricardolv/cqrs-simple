package com.richard.infrastructure.messaging.config;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Setter
@Configuration
public class RabbitmqRegisterProductProperties {

    @Value("${rabbitmq.product.setup}")
    private String setup;

    @Value("${spring.profiles.active}")
    private String version;

    private String exchange = "ms.exchange.register.product";
    private String routingKey = "ms.routing.register.product";
    private String queue = "ms.queue.register.product";
    private String endpoint = "rabbitmq:";

    public String getExchange() {
        return exchange.concat(".").concat(version);
    }
    public String getRoutingKey() {
        return routingKey.concat(".").concat(version);
    }
    public String getQueue() {
        return queue.concat(".").concat(version);
    }
    public String getEndpoint() {
        return endpoint.concat(getExchange())
                .concat("?routingKey=".concat(getRoutingKey())
                        .concat("&queue=").concat(getQueue())
                        .concat("&").concat(setup));
    }

}
