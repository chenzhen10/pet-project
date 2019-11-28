package by.itechart.demo.post.service.impl;

import by.itechart.demo.post.dto.PostDto;
import by.itechart.demo.post.repository.PostElasticRepository;
import by.itechart.demo.post.service.ElasticPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;


@Service
public class ElasticPostServiceImpl implements ElasticPostService {

    @Autowired
    private PostElasticRepository elasticRepository;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${activemq.destination}")
    private String destination;


    @Override
    public void insert(PostDto newPost) {
        elasticRepository.save(newPost);
        Long id = newPost.getId() ;
        sendMessage("Post indexed with id -> " + id);
    }


    private void sendMessage(String post) {
        // send to db server that indexed ok
        jmsTemplate.convertAndSend(destination, post);
    }
}
