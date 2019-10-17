package by.itechart.demo.post.service.impl;

import by.itechart.demo.post.model.Post;
import by.itechart.demo.post.repository.PostRepository;
import by.itechart.demo.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repository;

    @Transactional(readOnly = true)
    public Page<Post> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    @Override
    public Long create(Post p) {
        return repository.save(p).getId();
    }

    @Transactional
    @Override
    public void update(Long id,Post newPost ) {
        Post post =  repository.findById(id).get();
        post.setName(newPost.getName());
        post.setDate(newPost.getDate());
        post.setTag(newPost.getTag());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
