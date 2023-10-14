package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    void delete(long id);

    void update(User user);

    List<User> findAll();

    User findById(long id);
}
