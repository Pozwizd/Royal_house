package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.Building;
import com.pozwizd.royal_house.model.StatusBuilding;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BuildingService {

    public void save(Building building);

    public void delete(long id);

    public Building findById(long id);

    public void update(Building building);

    public List<Building> findAll();


    Page<Building> findByRequest(
            String name,
            String address,
            Pageable pageable);


    Page<Building> findAll(Pageable pageable);
}
