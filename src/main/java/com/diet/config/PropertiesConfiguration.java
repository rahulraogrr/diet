package com.diet.config;

import com.diet.properties.MessageProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources(
        value = {
                @PropertySource(value = {"classpath:messages.properties"})
        }
)
@EnableConfigurationProperties(
        value = {
                MessageProperties.class
        }
)
public class PropertiesConfiguration {

}
