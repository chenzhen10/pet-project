package by.itechart.demo.post.service;

import by.itechart.demo.post.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PostService {
    Page<Post> getAll(Pageable pageable);
    Long create(Post p);
    void update(Long id,Post newPost);
    void delete(Long id);
}
