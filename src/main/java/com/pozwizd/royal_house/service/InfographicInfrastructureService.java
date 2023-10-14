package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.InfographicInfrastructure;

import java.util.List;

public interface InfographicInfrastructureService {
    // Crud operations

    void save(InfographicInfrastructure infographicInfrastructure);

    void delete(long id);

    void update(InfographicInfrastructure infographicInfrastructure);

    List<InfographicInfrastructure> findAll();

    InfographicInfrastructure findById(long id);
}
