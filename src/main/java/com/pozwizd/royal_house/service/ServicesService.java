package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.Services;

import java.util.List;

public interface  ServicesService {

    public void saveServices(Services services);

    public Services getServices(long id);

    public void deleteServices(long id);

    public void updateServices(Services services);

    public List<Services> getAllServices();


}
