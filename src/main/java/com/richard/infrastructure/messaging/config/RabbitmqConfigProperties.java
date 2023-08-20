package com.richard.infrastructure.messaging.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "camel.component.rabbitmq")
public class RabbitmqConfigProperties {

    private String hostname;
    private Integer portNumber;
    private String username;
    private String password;
    private String virtualHost;

}
