package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.AboutCompany;
import com.pozwizd.royal_house.model.AboutProject;

import java.util.List;

public interface AboutCompanyService {
    // Crud operations

    void save(AboutCompany aboutCompany);

    void delete(long id);

    void update(AboutCompany aboutCompany);

    List<AboutCompany> findAll();

    AboutCompany findById(long id);
}
