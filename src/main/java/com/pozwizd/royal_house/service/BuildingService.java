package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.Building;
import com.pozwizd.royal_house.model.StatusBuilding;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BuildingService {

    public void save(Building building);

    public void delete(long id);

    public Building findById(long id);

    public void update(Building building);

    public Iterable<Building> findAll();


    Page<Building> findByRequest(
            String name,
            String address,
            StatusBuilding status,
            Pageable pageable);

    Page<Building> findByName(String name,
                              Pageable pageable);
}
