package java12.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java12.entity.Image;
import java12.entity.User;
import java12.entity.UserInfo;
import java12.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Repository
public class UserRepoImpl implements UserRepo {

    @PersistenceContext
    private final EntityManager entityManager;


    @Override
    public String signUp(User user) {
        UserInfo userInfo = new UserInfo();

        user.setUserInfo(userInfo);
        userInfo.setUser(user);
        entityManager.persist(user);
        return "User saved!";
    }

    @Override
    public User signIn(User user) {
        try {
            for (User currentUser : getAllUsers()) {
                if (currentUser.getUserName().equals(user.getUserName()) && currentUser.getPassword().equals(user.getPassword())){
                    return currentUser;
                }
            }
        }catch (Exception e){
            System.out.println("password je username tuura emes");
        }
        return null;
    }

    @Override
    public User getUserById(Long userId) {
        return entityManager.find(User.class, userId);
    }

    @Override
    public List<User> getAllUsers() {
        List users = entityManager.createQuery("select u from User u").getResultList();
        return users;
    }

    @Override
    public void updateUser(Long userId, User newUser) {

    }

    @Override
    public Optional<User> findById(Long userID) {
        return Optional.ofNullable(entityManager.find(User.class, userID));
    }

    @Override
    public User getUserByName(String name) {
        User user = entityManager.createQuery("select u from  User u where userName in :name", User.class)
                .setParameter("name", name)
                .getSingleResult();
        return user;
    }


}
