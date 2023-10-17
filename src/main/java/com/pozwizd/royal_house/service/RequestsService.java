package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.Requests;

import java.util.List;

public interface RequestsService {

    public void saveRequests(Requests requests);

    public Requests getRequests(long id);

    public void deleteRequests(long id);

    public void updateRequests(Requests requests);

    public List<Requests> findAll();

}
