package com.comiclysm.project.comiclysm.repositories;

import com.comiclysm.project.comiclysm.models.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Override
    <S extends User> S save(S s); // Saves a user
    List<User> findAllByUserName(String userName);
    Iterable<User> findAll();
    User findUserByUserNameAndUserPassword(String userName, String userPassword);
}
