package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.InfrastructureBuilding;

import java.util.List;

public interface InfrastructureBuildingService {

    public void saveInfrastructureBuilding(InfrastructureBuilding infrastructureBuilding);

    public InfrastructureBuilding getInfrastructureBuilding(long id);

    public void deleteInfrastructureBuilding(long id);

    public void updateInfrastructureBuilding(InfrastructureBuilding infrastructureBuilding);

    public List<InfrastructureBuilding> findAllInfrastructureBuildings();

}
