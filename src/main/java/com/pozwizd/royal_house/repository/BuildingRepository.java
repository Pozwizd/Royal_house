package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Long> {
}