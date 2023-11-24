package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.AdditionalEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalEmailRepository extends JpaRepository<AdditionalEmail, Long> {
}