package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.InfographicInfrastructure;

import java.util.List;

public interface InfographicInfrastructureService {

    public void saveInfographicInfrastructure(InfographicInfrastructure infographicInfrastructure);
    public InfographicInfrastructure getInfographicInfrastructure(long id);
    public void deleteInfographicInfrastructure(long id);
    public void updateInfographicInfrastructure(InfographicInfrastructure infographicInfrastructure);
    public List<InfographicInfrastructure> findAllInfographicInfrastructures();

}
