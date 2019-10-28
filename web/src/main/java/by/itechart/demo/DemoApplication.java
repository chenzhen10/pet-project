package by.itechart.demo;

import by.itechart.demo.configuration.CoreConfiguration;
import by.itechart.demo.configuration.SwaggerConfiguration;
import by.itechart.demo.configuration.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({CoreConfiguration.class, WebSecurityConfig.class, SwaggerConfiguration.class})
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }
}
