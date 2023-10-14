package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.InfrastructureNewBuilding;

import java.util.List;

public interface InfrastructureNewBuildingService {
    // Crud operations

    void save(InfrastructureNewBuilding infrastructureNewBuilding);

    void update(InfrastructureNewBuilding infrastructureNewBuilding);

    void delete(long id);


    List<InfrastructureNewBuilding> findAll();

    InfrastructureNewBuilding findById(long id);
}
