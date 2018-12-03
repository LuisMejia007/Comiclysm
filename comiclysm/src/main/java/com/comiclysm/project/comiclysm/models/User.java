package com.comiclysm.project.comiclysm.models;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    int userId;

    @Column(name = "user_name")
    String userName;

    @Column(name = "user_password")
    String userPassword;


//    @OneToMany(mappedBy = "user")
//    List<Inventory> userInventories;

    public User() { }

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
