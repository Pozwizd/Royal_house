package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.User;

import java.util.List;

public interface UserService {

    public void saveUser(User user);
    public List<User> getAllUsers();
    public User getUserById(long id);
    public void deleteUser(long id);

    public void updateUser(User user);

}
