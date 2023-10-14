package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.SpecificationNewBuilding;

import java.util.List;

public interface SpecificationNewBuildingService {

    void save(SpecificationNewBuilding specificationNewBuilding);
    void deleteById(Long id);

    void update(SpecificationNewBuilding specificationNewBuilding);

    List<SpecificationNewBuilding> findAll();

    SpecificationNewBuilding findById(long id);

}
