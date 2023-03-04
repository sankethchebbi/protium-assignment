package com.example.protiumv2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.protiumv2.model.protiumBlogPost;
import com.example.protiumv2.repository.protiumBlogPostRepository;

@Service
public class protiumBlogPostService {

  @Autowired
  private BlogPostRepository repository;

  public List<BlogPost> getAllBlogPosts() {
    return repository.findAll();
  }

  public BlogPost getBlogPostById(Long id) {
    return repository.findById(id).orElse(null);
  }

  public BlogPost createBlogPost(BlogPost post) {
    return repository.save(post);
  }

  public BlogPost updateBlogPost(Long id, BlogPost post) {
    BlogPost existingPost = repository.findById(id).orElse(null);
    if (existingPost == null) {
      return null;
    }
    existingPost.setTitle(post.getTitle());
    existingPost.setContent(post.getContent());
    return repository.save(existingPost);
  }

  public boolean deleteBlogPost(Long id) {
    repository.deleteById(id);
    return true;
  }
}
