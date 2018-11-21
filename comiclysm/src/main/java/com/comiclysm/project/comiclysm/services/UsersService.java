package com.comiclysm.project.comiclysm.services;

import com.comiclysm.project.comiclysm.models.User;
import com.comiclysm.project.comiclysm.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();
        this.userRepository.findAll().forEach(users::add);
        return users;
    }

    public void addUser(User user) {
        System.out.println("User: " + user.getUserName() + " " + user.getUserPassword());
        this.userRepository.save(user);
    }
}
