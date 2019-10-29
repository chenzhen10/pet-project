package by.itechart.demo.post.service.impl;

import by.itechart.demo.configuration.DevConfiguration;
import by.itechart.demo.post.dto.CreatePostDto;
import by.itechart.demo.post.dto.PostDto;
import by.itechart.demo.post.model.Post;
import by.itechart.demo.post.repository.elastic.PostElasticRepository;
import by.itechart.demo.post.repository.jpa.PostRepository;
import by.itechart.demo.post.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PostRepository jpaRepository;

    @Autowired
    private PostElasticRepository elasticRepository;

    @Transactional(readOnly = true)
    public Page<PostDto> getAll(Pageable pageable) {
        Page<Post> posts = jpaRepository.findAll(pageable);
        if (posts.getSize() == 0) {
          DevConfiguration dev = new DevConfiguration();
          dev.populateDate(jpaRepository);
        }

        return posts.map(post -> mapper.map(post, PostDto.class));
    }

    @Transactional
    @Override
    public Long create(CreatePostDto p) {
        Post post = mapper.map(p, Post.class);
        Post newPost =  jpaRepository.save(post);
        return elasticRepository.save(newPost).getId();
    }

    @Transactional
    @Override
    public void update(Long id, CreatePostDto newPost) {
        Post post = jpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity was not found..."));
        mapper.map(newPost, post);
        jpaRepository.save(post);
        elasticRepository.save(post);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
        elasticRepository.deleteById(id);
    }



}
