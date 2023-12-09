package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.AboutCompany;
import com.pozwizd.royal_house.repository.AboutCompanyRepository;
import com.pozwizd.royal_house.service.AboutCompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AboutCompanyServiceImp implements AboutCompanyService {

    private final AboutCompanyRepository aboutCompanyRepository;


    @Override
    public void addAboutCompany(AboutCompany aboutCompany) {
        aboutCompanyRepository.save(aboutCompany);
    }

    @Override
    public AboutCompany findAboutCompanyById(long id) {
        return aboutCompanyRepository.findById(id).orElse(null);
    }

    @Override
    public void updateAboutCompany(AboutCompany aboutCompany) {
        aboutCompanyRepository.save(aboutCompany);
    }

    @Override
    public void deleteAboutCompany(long id) {
        aboutCompanyRepository.deleteById(id);
    }

    @Override
    public List<AboutCompany> findAllAboutCompanies() {
        return aboutCompanyRepository.findAll();
    }
}
