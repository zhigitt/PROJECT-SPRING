package java12.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java12.entity.Image;
import java12.entity.Post;
import java12.entity.User;
import java12.repo.ImageRepo;
import java12.repo.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Repository

public class PostRepoImpl implements PostRepo {

    @PersistenceContext
    private final EntityManager entityManager;
    private ImageRepo imageRepo;

    @Override
    public User createPost(Long userId, Post post) {
        User user = entityManager.find(User.class, userId);
        user.addPost(post);
        post.setUser(user);
        entityManager.persist(post);
        return user;
    }

    @Override
    public Post getPostById(Long postId) {
        return null;
    }

    @Override
    public List<Post> getAllPostsByUserId(Long userId) {
        return entityManager.createQuery("select p from Post p where p.user.id = :usId", Post.class)
                .setParameter("usId", userId)
                .getResultList();
    }

    @Override
    public String updatePostById(Long postId) {
        return null;
    }

    @Override
    public void deletePostById(Long postId) {

    }
}
