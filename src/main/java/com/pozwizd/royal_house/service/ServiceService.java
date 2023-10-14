package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.Service;

import java.util.List;

public interface ServiceService {
    // Crud operations
    void save(Service service);

    void delete(long id);

    void update(Service service);

    List<Service> findAll();

    Service findById(long id);

}
