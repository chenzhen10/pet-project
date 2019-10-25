package by.itechart.demo.post.service.impl;

import by.itechart.demo.post.dto.CreatePostDto;
import by.itechart.demo.post.dto.PostDto;
import by.itechart.demo.post.model.Post;
import by.itechart.demo.post.repository.PostRepository;
import by.itechart.demo.post.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PostRepository postRepository;

    @Transactional(readOnly = true)
    public Page<PostDto> getAll(Pageable pageable) {
        Page<Post> posts = postRepository.findAll(pageable);

        if (posts.getSize() == 0) {
            populateDate();
        }

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

//??
    @Profile("dev")
    private void populateDate() {
        List<Post> posts = new ArrayList<>();
        posts.add(Post.builder().name("Hotpost").date(new Date(2019, 5, 13))
                .body("Since the beginning of the internet, millions and millions and millions of blogs have been created. " +
                        "Many have died due to lost interest or their owners giving up on the idea, while others " )
                .tag("#wow").build());
        posts.add(Post.builder().name("Newpost").date(new Date(2019, 1, 23))
                .body("Each example listed in this blog post are all different in some way and all bring something unique to their readers & subscribers." +
                " I want to show you what is possible and how you can take inspiration from them " +
                "and create an awesome blog of your own.").tag("#wow").build());

        posts.add(Post.builder().name("Oldpost").date(new Date(2019, 7, 12))
                .body("Some of these blogs make over" +
                " $100k a month, others are just a hobby for their owners, but all have the same purpose at their " +
                "core… the love of writing and sharing information.").tag("#hh").build());

        posts.add(Post.builder().name("Coolpost").date(new Date(2019, 3, 11))
                .body("Remember that it doesn’t cost the earth to start your own blog. " +
                        "You can be up and running for as little as $1.45 per month with Hostinger.").tag("#col").build());
        postRepository.saveAll(posts);
    }

}
