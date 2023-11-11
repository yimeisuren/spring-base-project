package org.example.service;

import org.example.annotation.Pt01;
import org.example.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void save(User user) {
        System.out.println("user = " + user);
    }

    public void update(User user) {
        System.out.println("user = " + user);
    }

    @Pt01
    public boolean delete(User user) {
        System.out.println("user = " + user);
        return true;
    }

    @Pt01
    public User findById(Integer id) {
        User user = new User(id, "root");
        System.out.println("user = " + user);
        return user;
    }
}
