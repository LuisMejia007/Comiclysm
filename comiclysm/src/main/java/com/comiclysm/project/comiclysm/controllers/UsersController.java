package com.comiclysm.project.comiclysm.controllers;


import com.comiclysm.project.comiclysm.models.User;
import com.comiclysm.project.comiclysm.services.UsersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@SessionAttributes({"username"})
public class UsersController {

    @Autowired
    UsersService usersService;

    public static final String ipAdd = "http://10.35.46.112:4200";
    public static final String localHostClient = "http://localhost:1200";

    @CrossOrigin(origins = localHostClient)
    @GetMapping(value="allUsers/")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<User> getAllUsers() {
      return this.usersService.getAllUsers();
    }

    @CrossOrigin(origins = localHostClient)
    @PostMapping(value = "register/{userName}_{userPassword}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    void addUser(@PathVariable String userName, @PathVariable String userPassword) {
        User user = new User(userName, userPassword);
        this.usersService.addUser(user);
    }


    @CrossOrigin(origins = localHostClient)
    @GetMapping(value="login/{userName}_{userPassword}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    User login(@PathVariable String userName, @PathVariable String userPassword, ModelMap model, HttpSession httpSession) {
        User user = this.usersService.userLogin(userName, userPassword);
        return user;
    }
}
