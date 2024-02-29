package java12.service;

import java12.entity.Post;
import java12.entity.User;

import java.util.List;

public interface PostService {


    User createPost(Long userId, Post post);

    Post getPostById(Long postId);

    List<Post> getAllPostsByUserId(Long userId);
    List<Post> getAllPosts();

    String updatePostById(Long postId);

    void deletePostById(Long postId);
}
