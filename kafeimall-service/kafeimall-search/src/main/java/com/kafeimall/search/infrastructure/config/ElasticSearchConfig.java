package com.kafeimall.search.infrastructure.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.config.EnableElasticsearchAuditing;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author: zzg
 * @date: 2023/3/11
 * @Description: 配置DataES客户端
 */
@Configuration
@EnableElasticsearchRepositories
@EnableElasticsearchAuditing
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

    @Value("${elastic-search.address}")
    private String elasticSearchAddress;


    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {

        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(elasticSearchAddress)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
