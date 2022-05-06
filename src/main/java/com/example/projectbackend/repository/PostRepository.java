package com.example.projectbackend.repository;

import com.example.projectbackend.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findByMessage(String message);

    @Query(value = "SELECT * FROM posts p WHERE LENGTH(p.message) > 20",
        nativeQuery = true)
    List<Post> findLongPosts();
}
