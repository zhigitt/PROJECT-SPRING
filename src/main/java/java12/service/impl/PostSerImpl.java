package java12.service.impl;

import java12.entity.Post;
import java12.entity.User;
import java12.repo.PostRepo;
import java12.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class PostSerImpl implements PostService {

    private final PostRepo postRepo;

    @Override
    public User createPost(Long userId, Post post) {
        return postRepo.createPost(userId, post);
    }

    @Override
    public Post getPostById(Long postId) {
        return postRepo.getPostById(postId);
    }

    @Override
    public List<Post> getAllPostsByUserId(Long userId) {
        return postRepo.getAllPostsByUserId(userId);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepo.getAllPosts();
    }

    @Override
    public String updatePostById(Long postId) {
        return postRepo.updatePostById(postId);
    }

    @Override
    public void deletePostById(Long postId) {
        postRepo.deletePostById(postId);
    }
}
