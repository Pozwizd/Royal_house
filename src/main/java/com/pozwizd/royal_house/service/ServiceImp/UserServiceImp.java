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
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElse(null);
    }
}
