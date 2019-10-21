package by.itechart.demo.post.service.impl;

import by.itechart.demo.post.dto.CreatePostDto;
import by.itechart.demo.post.dto.PostDto;
import by.itechart.demo.post.model.Post;
import by.itechart.demo.post.repository.PostRepository;
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

//    @Autowired
//    private ElasticPostRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PostRepository postRepository;

    @Transactional(readOnly = true)
    public Page<PostDto> getAll(Pageable pageable) {
        Page<Post> posts = postRepository.findAll(pageable);
        return posts.map(post -> mapper.map(post, PostDto.class));
    }

    @Transactional
    @Override
    public Long create(CreatePostDto p) {
        Post post = mapper.map(p, Post.class);
        return postRepository.save(post).getId();
    }

    @Transactional
    @Override
    public void update(Long id, CreatePostDto newPost) {
        Post post = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity was not found..."));
        mapper.map(newPost, post);
        postRepository.save(post);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
