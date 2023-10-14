package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.AboutCompany;
import com.pozwizd.royal_house.model.AboutProject;
import com.pozwizd.royal_house.repository.AboutProjectRepository;
import com.pozwizd.royal_house.service.AboutCompanyService;
import com.pozwizd.royal_house.service.AboutProjectService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AboutProjectServiceImp implements AboutProjectService {

    private final AboutProjectRepository aboutProjectRepository;

    public AboutProjectServiceImp(AboutProjectRepository aboutProjectRepository) {
        this.aboutProjectRepository = aboutProjectRepository;
    }


    @Override
    public void save(AboutProject aboutProject) {
        aboutProjectRepository.save(aboutProject);
    }

    @Override
    public void update(AboutProject aboutProject) {
        aboutProjectRepository.save(aboutProject);
    }

    @Override
    public void delete(long id) {
        aboutProjectRepository.deleteById(id);
    }

    @Override
    public List<AboutProject> findAll() {
        return aboutProjectRepository.findAll();
    }

    @Override
    public AboutProject findById(long id) {
        return aboutProjectRepository.findById(id).orElse(null);
    }
}
