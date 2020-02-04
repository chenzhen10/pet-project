package by.itechart.demo.post.controller;


import by.itechart.demo.post.dto.PostDto;
import by.itechart.demo.post.service.ElasticPostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Controller;

import javax.jms.JMSException;
import java.io.IOException;

@Controller
@Slf4j
public class PostController {

    @Autowired
    private ElasticPostService postService;

    @Autowired
    private ObjectMapper mapper;


    @JmsListener(destination = "post.created")
    public void indexPost(ActiveMQTextMessage message) throws JMSException {
        PostDto p = null;
        try {
            p = mapper.readValue(message.getText(), PostDto.class);
        } catch (IOException e) {
            log.error("Error -> " + e);
        }
        log.info("Indexed -> {} ", p);
        postService.insert(p);
    }


}
