package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.Building;
import com.pozwizd.royal_house.model.SpecificationBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SpecificationBuildingRepository extends JpaRepository<SpecificationBuilding, Long> {

    @Query("SELECT sp FROM SpecificationBuilding sp WHERE sp.building = :building")
    public SpecificationBuilding findByBuilding(Building building);
}