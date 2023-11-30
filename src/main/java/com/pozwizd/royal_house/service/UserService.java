package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> selectAllUsers();
    Optional<User> selectUserById(Long userId);
    void insertUser(User customer);

    boolean existsUserWithEmail(String email);
    boolean existsUserById(Long userId);
    void deleteUserById(Long userId);
    void updateUser(User update);
    Optional<User> findByName(String username);
    Optional<User> selectUserByEmail(String email);

}
