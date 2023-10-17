package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.Building;

import java.util.List;

public interface BuildingService {

    public void save(Building building);

    public void delete(long id);

    public Building findById(long id);

    public void update(Building building);

    public List<Building> findAll();
}
