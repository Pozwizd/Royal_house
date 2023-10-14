package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.InfographicNewBuilding;

import java.util.List;

public interface InfographicNewBuildingService {
    // Crud operations
    void save(InfographicNewBuilding infographicNewBuilding);

    void update(InfographicNewBuilding infographicNewBuilding);

    void delete(long id);

    List<InfographicNewBuilding> findAll();

    InfographicNewBuilding findById(long id);
}
