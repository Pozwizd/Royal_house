package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.RoomBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomBuildingRepository extends JpaRepository<RoomBuilding, Long> {
}