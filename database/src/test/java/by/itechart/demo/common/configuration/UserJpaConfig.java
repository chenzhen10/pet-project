package by.itechart.demo.common.configuration;

import by.itechart.demo.post.dto.CreatePostDto;
import by.itechart.demo.post.model.Post;
import by.itechart.demo.user.dto.CreateUserDto;
import by.itechart.demo.user.model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableJpaRepositories(basePackages = "by.itechart.demo")
@PropertySource("application-test.properties")
@ComponentScan("by.itechart.demo.*.service")
@EnableTransactionManagement
public class UserJpaConfig {

    @Autowired
    private Environment env;


    @Profile("test")
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("by.itechart.demo");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    final Properties additionalProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        return hibernateProperties;
    }

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();

        TypeMap<CreatePostDto, Post> createPostMapping = mapper.createTypeMap(CreatePostDto.class,Post.class);
        createPostMapping.addMappings(m -> m.skip(Post::setId));

        TypeMap<CreateUserDto, User> createUserMapping = mapper.createTypeMap(CreateUserDto.class,User.class);
        createUserMapping.addMappings(m -> m.skip(User::setId));

        return mapper;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}