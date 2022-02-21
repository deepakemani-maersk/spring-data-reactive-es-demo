package com.maersk.springdatareactiveesdemo.config;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient;
import org.springframework.data.elasticsearch.client.reactive.ReactiveRestClients;
import org.springframework.data.elasticsearch.config.AbstractReactiveElasticsearchConfiguration;
import org.springframework.http.HttpHeaders;

import java.time.Duration;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class ElasticsearchConfig extends AbstractReactiveElasticsearchConfiguration {

    private static final String LOCAL = "local";
    @Value("${spring.elasticsearch.host}")
    private String elasticSearchHostname;
    @Value("${spring.elasticsearch.api-key}")
    private String apiKey;
    @Value("${spring.profiles.active}")
    private String activeProfile;

    private final ConfigurableApplicationContext springContext;

    @Bean
    public ClientConfiguration clientConfiguration() {
        if (LOCAL.equalsIgnoreCase(activeProfile)) {
            return ClientConfiguration.builder()
                    .connectedTo(elasticSearchHostname)
                    .withConnectTimeout(Duration.ofMinutes(5))
                    .withSocketTimeout(Duration.ofMinutes(5))
                    .withHeaders(() -> {
                        HttpHeaders headers = new HttpHeaders();
                        headers.add("Authorization", "ApiKey " + apiKey);
                        return headers;
                    })
                    .build();
        } else {
            return ClientConfiguration.builder()
                    .connectedTo(elasticSearchHostname)
                    .usingSsl()
                    .withConnectTimeout(Duration.ofMinutes(5))
                    .withSocketTimeout(Duration.ofMinutes(5))
                    .withHeaders(() -> {
                        HttpHeaders headers = new HttpHeaders();
                        headers.add("Authorization", "ApiKey " + apiKey);
                        return headers;
                    })
                    .build();
        }
    }

    @SneakyThrows
    @Bean
    @Override
    public ReactiveElasticsearchClient reactiveElasticsearchClient() {

        final ClientConfiguration clientConfiguration = clientConfiguration();

        log.info("Configuring Elastic search in profile {}", activeProfile);

        return ReactiveRestClients.create(clientConfiguration);
    }

}