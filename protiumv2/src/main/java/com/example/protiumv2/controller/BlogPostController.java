package com.example.protiumv2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blog")
public class BlogPostController {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @GetMapping("/all")
    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getBlogPostById(@PathVariable(value = "id") Long blogPostId) {
        Optional<BlogPost> blogPost = blogPostRepository.findById(blogPostId);
        if (blogPost.isPresent()) {
            return ResponseEntity.ok().body(blogPost.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable(value = "id") Long blogPostId, @RequestBody BlogPost blogPostDetails) {
        Optional<BlogPost> optionalBlogPost = blogPostRepository.findById(blogPostId);
        if (optionalBlogPost.isPresent()) {
            BlogPost blogPost = optionalBlogPost.get();
            blogPost.setTitle(blogPostDetails.getTitle());
            blogPost.setContent(blogPostDetails.getContent());
            blogPost.setAuthor(blogPostDetails.getAuthor());
            BlogPost updatedBlogPost = blogPostRepository.save(blogPost);
            return ResponseEntity.ok(updatedBlogPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBlogPost(@PathVariable(value = "id") Long blogPostId) {
        try {
            blogPostRepository.deleteById(blogPostId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
