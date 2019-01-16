package io.github.gkdlaos.springbootexample.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.gkdlaos.springbootexample.dao.UserDAO;
import io.github.gkdlaos.springbootexample.model.User;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public void register(User user) {
        userDAO.insert(user);
    }

    public User logIn(String userId, String password) {
        User user = userDAO.getByUserId(userId);
        if (user != null && Objects.equals(user.getPassword(), password)) {
            return user;
        } else {
            return null;
        }
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
