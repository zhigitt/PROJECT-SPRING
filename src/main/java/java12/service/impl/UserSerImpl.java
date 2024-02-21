package java12.service.impl;

import jakarta.transaction.Transactional;
import java12.entity.User;
import java12.repo.UserRepo;
import java12.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserSerImpl implements UserService {

    private final UserRepo userRepo;
    public static User currentUser;

    @Override
    public String signUp(User user) {
        return userRepo.signUp(user);
    }

    @Override
    public User signIn(User user) {
        currentUser = userRepo.signIn(user);
        return currentUser;
    }

    @Override
    public User getUserById(Long userId) {
        return userRepo.getUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    @Override
    public void updateUser(Long userId, User newUser) {
        userRepo.updateUser(userId, newUser);
    }

    @Override
    public User findById(Long userID) {
        return userRepo.findById(userID).orElseThrow(() -> new RuntimeException("User with id: "+" not found"));
    }
}
