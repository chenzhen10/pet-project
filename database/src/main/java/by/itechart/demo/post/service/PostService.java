package by.itechart.demo.post.service;

import by.itechart.demo.post.dto.CreatePostDto;
import by.itechart.demo.post.dto.PostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PostService {
    Page<PostDto> getAll(Pageable pageable);
    Long create(CreatePostDto p);
    void update(Long id,CreatePostDto newPost);
    void delete(Long id);
    Iterable<PostDto> search(String word);
}
