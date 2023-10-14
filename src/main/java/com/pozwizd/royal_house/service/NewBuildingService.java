package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.NewBuilding;

import java.util.List;

public interface NewBuildingService {

    // Crud operations
    void save(NewBuilding newBuilding);

    void delete(long id);

    void update(NewBuilding newBuilding);

    List<NewBuilding> findAll();

    NewBuilding findById(long id);
}
