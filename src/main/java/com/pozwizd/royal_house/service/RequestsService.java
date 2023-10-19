package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.Requests;
import com.pozwizd.royal_house.model.Status;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface RequestsService {

    public void saveRequests(Requests requests);

    public Requests getRequests(long id);

    public void deleteRequests(long id);

    public void updateRequests(Requests requests);

    public Page<Requests> findAll(Pageable pageable);

}