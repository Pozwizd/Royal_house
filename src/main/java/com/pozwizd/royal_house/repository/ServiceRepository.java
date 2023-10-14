package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}