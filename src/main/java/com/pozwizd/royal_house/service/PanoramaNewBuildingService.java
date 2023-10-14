package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.PanoramaNewBuilding;

import java.util.List;

public interface PanoramaNewBuildingService {
    // Crud operations
    void save(PanoramaNewBuilding panoramaNewBuilding);

    void delete(long id);

    void deleteById(Long id);

    List<PanoramaNewBuilding> findAll();

    PanoramaNewBuilding findById(long id);
}
