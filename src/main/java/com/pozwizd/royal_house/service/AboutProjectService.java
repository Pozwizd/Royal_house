package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.AboutProject;

import java.util.List;

public interface AboutProjectService {
    // Crud operations

    void save(AboutProject aboutProject);

    void update(AboutProject aboutProject);

    void delete(long id);

    List<AboutProject> findAll();

    AboutProject findById(long id);

}
