package by.itechart.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories("by.itechart.demo.*.repository")
public class ElasticSearchConfiguration {

}
