package com.bootlabs.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class FakeStoreClientConfig {

    @Bean
    public RestClient fakeStoreClient(RestClient.Builder builder) {
        return builder
                .baseUrl("https://fakestoreapi.com")
                .build();
    }
}
