package java12.service;

import java12.entity.User;

import java.util.List;


public interface UserService {

    String signUp(User user);

    User signIn(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    void updateUser(Long userId, User newUser);

    User findById(Long userID);

    User getUserByName(String name);
}
