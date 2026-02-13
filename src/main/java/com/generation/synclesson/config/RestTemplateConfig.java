package com.generation.synclesson.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /**
     * RestTemplate usato per chiamate REST.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
}
