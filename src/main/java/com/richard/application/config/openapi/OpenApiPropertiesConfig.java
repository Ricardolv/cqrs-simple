package com.richard.application.config.openapi;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring")
public class OpenApiPropertiesConfig {

    private String appVersion;

}
