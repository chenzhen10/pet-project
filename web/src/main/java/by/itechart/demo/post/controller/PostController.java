package by.itechart.demo.post.controller;


import by.itechart.demo.post.model.Post;
import by.itechart.demo.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/api/posts")
public class PostController {


    @Autowired
    private PostService postService;

    @GetMapping
    public Page<Post> getAllPosts(Pageable pageable) {
        return postService.getAll(pageable);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post p) {
        Long id = postService.create(p);
        URI uri = URI.create(id.toString());
        return ResponseEntity.created(uri).body(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok(id.toString());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePost(@PathVariable Long id ,@RequestBody Post p) {
        postService.update(id,p);
        return ResponseEntity.ok(id.toString());
    }


}
