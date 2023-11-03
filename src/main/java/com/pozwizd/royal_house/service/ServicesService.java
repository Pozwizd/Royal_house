package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.Requests;
import com.pozwizd.royal_house.model.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface  ServicesService {

    public void saveServices(Services services);

    public Services getServices(long id);

    public void deleteServices(long id);

    public void updateServices(Services services);

    public List<Services> getAllServices();

    public Page<Services> findAll(Pageable pageable);

    Page<Services> findByRequest(String name, Pageable pageable);


}
