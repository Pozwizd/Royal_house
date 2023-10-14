package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.RoomNewBuilding;

import java.util.List;

public interface RoomNewBuildingService {
    // Crud operations
    void save(RoomNewBuilding roomNewBuilding);

    void update(RoomNewBuilding roomNewBuilding);

    void delete(long id);

    List<RoomNewBuilding> findAll();

    RoomNewBuilding findById(long id);
}
