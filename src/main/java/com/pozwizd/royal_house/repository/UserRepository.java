package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}