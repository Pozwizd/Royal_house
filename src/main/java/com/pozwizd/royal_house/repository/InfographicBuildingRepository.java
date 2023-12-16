package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.InfographicBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InfographicBuildingRepository extends JpaRepository<InfographicBuilding, Long> {

    List<InfographicBuilding> findAllByBuildingId(long buildingId);
}