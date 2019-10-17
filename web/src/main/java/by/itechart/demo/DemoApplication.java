package by.itechart.demo;

import by.itechart.demo.common.config.CoreConfiguration;
import by.itechart.demo.common.config.ElasticConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({CoreConfiguration.class,ElasticConfiguration.class})
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }
}
