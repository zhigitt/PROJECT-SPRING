package java12.repo;

import java12.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo {

    String signUp(User user);
    User signIn(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    void updateUser(Long userId, User newUser);

    Optional<User> findById(Long userID);

    User getUserByName(String name);
}
