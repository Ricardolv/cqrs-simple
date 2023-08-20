package com.richard.infrastructure.messaging.config;

import com.rabbitmq.client.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class CamelConfig {

    private final RabbitmqConfigProperties rabbitmqConfig;

    @Bean
    public ConnectionFactory connectionFactory() {
        ConnectionFactory con = new ConnectionFactory();
        con.setHost(rabbitmqConfig.getHostname());
        con.setPort(rabbitmqConfig.getPortNumber());
        con.setUsername(rabbitmqConfig.getUsername());
        con.setPassword(rabbitmqConfig.getPassword());
        con.setVirtualHost(rabbitmqConfig.getVirtualHost());
        return con;
    }
}
