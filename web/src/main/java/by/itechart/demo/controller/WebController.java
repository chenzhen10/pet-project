package by.itechart.demo.controller;


import by.itechart.demo.post.model.Post;
import by.itechart.demo.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/posts")
public class WebController {

    @Autowired
    private PostRepository repository;


    @GetMapping
    public List<Post> get() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post p) {
        Long id = repository.save(p).getId();
        URI uri = URI.create(id.toString());
        return ResponseEntity.created(uri).body(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok(id.toString());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePost(@PathVariable Long id ,@RequestBody Post p) {
        Post post =  repository.getOne(id);
        post.setName(p.getName());
        post.setDate(p.getDate());
        post.setTag(p.getTag());
        repository.save(post);
        return ResponseEntity.ok(id.toString());
    }


}
