package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.AboutCompany;

import java.util.List;

public interface AboutCompanyService {

    public void addAboutCompany(AboutCompany aboutCompany);

    public AboutCompany findAboutCompanyById(long id);

    public void updateAboutCompany(AboutCompany aboutCompany);

    public void deleteAboutCompany(long id);

    public List<AboutCompany> findAllAboutCompanies();

}
