package by.itechart.demo.configuration;

import by.itechart.demo.post.dto.CreatePostDto;
import by.itechart.demo.post.model.Post;
import by.itechart.demo.user.dto.CreateUserDto;
import by.itechart.demo.user.model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@Configuration
@ComponentScan("by.itechart.demo")
@EnableJpaRepositories("by.itechart.demo.*.repository.jpa")
@EnableElasticsearchRepositories("by.itechart.demo.*.repository.elastic")
public class CoreConfiguration  {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();

        TypeMap<CreatePostDto, Post> createPostMapping = mapper.createTypeMap(CreatePostDto.class,Post.class);
        createPostMapping.addMappings(m -> m.skip(Post::setId));

        TypeMap<CreateUserDto, User> createUserMapping = mapper.createTypeMap(CreateUserDto.class,User.class);
        createUserMapping.addMappings(m -> m.skip(User::setId));

        return mapper;
    }

}
