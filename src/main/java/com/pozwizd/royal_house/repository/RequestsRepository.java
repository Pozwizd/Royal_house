package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.Requests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestsRepository extends JpaRepository<Requests, Long> {
}