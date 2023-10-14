package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.LocationNewBuilding;

import java.util.List;

public interface LocationNewBuildingService {
    // Crud operations

    void save(LocationNewBuilding locationNewBuilding);

    void update(LocationNewBuilding locationNewBuilding);

    void delete(long id);

    List<LocationNewBuilding> findAll();

    LocationNewBuilding findById(long id);
}
