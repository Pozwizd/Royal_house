package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.AdditionalEmail;
import com.pozwizd.royal_house.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdditionalEmailRepository extends JpaRepository<AdditionalEmail, Long> {

    List<AdditionalEmail> findAllByUser(User user);
}