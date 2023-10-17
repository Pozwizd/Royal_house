package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.SpecificationBuilding;

import java.util.List;

public interface SpecificationBuildingService {

    public void saveSpecificationBuilding(SpecificationBuilding specificationBuilding);

    public SpecificationBuilding getSpecificationBuilding(long id);

    public void deleteSpecificationBuilding(long id);

    public void updateSpecificationBuilding(SpecificationBuilding specificationBuilding);

    public List<SpecificationBuilding> findAllSpecificationBuildings();

}
