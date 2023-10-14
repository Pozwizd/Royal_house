package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.AboutCompany;
import com.pozwizd.royal_house.repository.AboutCompanyRepository;
import com.pozwizd.royal_house.service.AboutCompanyService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AboutCompanyServiceImp implements AboutCompanyService {

    private final AboutCompanyRepository aboutCompanyRepository;

    public AboutCompanyServiceImp(AboutCompanyRepository aboutCompanyRepository) {
        this.aboutCompanyRepository = aboutCompanyRepository;
    }


    @Override
    public void save(AboutCompany aboutCompany) {
        aboutCompanyRepository.save(aboutCompany);
    }

    @Override
    public void delete(long  id) {
        aboutCompanyRepository.deleteById(id);
    }

    @Override
    public void update(AboutCompany aboutCompany) {
        aboutCompanyRepository.save(aboutCompany);
    }

    @Override
    public List<AboutCompany> findAll() {
        return aboutCompanyRepository.findAll();
    }

    @Override
    public AboutCompany findById(long id) {
        return aboutCompanyRepository.findById(id).orElse(null);
    }
}
