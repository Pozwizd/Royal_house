package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String username);
    boolean existsUserByEmail(String email);
    boolean existsUserById(Long id);
    Optional<User> findUserByEmail(String email);
}