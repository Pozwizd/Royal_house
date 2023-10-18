package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.User;
import com.pozwizd.royal_house.repository.UserRepository;
import com.pozwizd.royal_house.service.UserService;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
