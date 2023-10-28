package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.Requests;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface RequestsService {

    public void saveRequests(Requests requests);

    public Requests getRequests(long id);

    public void deleteRequests(long id);

    public void updateRequests(Requests requests);

    public Page<Requests> findAll(Pageable pageable);

    Page<Requests> findByRequest(String name, String phoneNumber, String email, Pageable pageable);
}