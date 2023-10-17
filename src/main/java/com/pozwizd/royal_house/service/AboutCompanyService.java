package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.AboutCompany;

import java.util.List;

public interface AboutCompanyService {

    public void saveAboutCompany(AboutCompany aboutCompany);

    public void deleteAboutCompany(long id);

    public AboutCompany findAboutCompanyById(long id);

    public List<AboutCompany> findAllAboutCompanies();
}
