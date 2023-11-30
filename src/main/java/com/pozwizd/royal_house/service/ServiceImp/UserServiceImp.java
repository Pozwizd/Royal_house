package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.User;
import com.pozwizd.royal_house.repository.UserRepository;
import com.pozwizd.royal_house.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class UserServiceImp implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> selectAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> selectUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void insertUser(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean existsUserWithEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }

    @Override
    public boolean existsUserById(Long userId) {
        return userRepository.existsUserById(userId);
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void updateUser(User update) {
        userRepository.save(update);
    }

    @Override
    public Optional<User> findByName(String username) {
        return userRepository.findByName(username);
    }

    @Override
    public Optional<User> selectUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Username " + email + " not found"));
    }
}
