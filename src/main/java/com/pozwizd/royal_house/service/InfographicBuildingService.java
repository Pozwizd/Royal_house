package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.InfographicBuilding;

import java.util.List;

public interface InfographicBuildingService {

    public void saveInfographicBuilding(InfographicBuilding infographicBuilding);

    public InfographicBuilding getInfographicBuilding(long id);

    public void deleteInfographicBuilding(long id);

    public void updateInfographicBuilding(InfographicBuilding infographicBuilding);

    public List<InfographicBuilding> findAllInfographicBuildings();
}
