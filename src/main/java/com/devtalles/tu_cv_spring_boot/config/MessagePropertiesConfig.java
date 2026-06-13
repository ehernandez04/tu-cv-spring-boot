package com.devtalles.tu_cv_spring_boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:message.properties")
})
public class MessagePropertiesConfig {

}



