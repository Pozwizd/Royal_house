package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.Subject;

import java.util.List;

public interface SubjectService {
    // Crud operations
    void save(Subject subject);

    void update(Subject subject);

    void delete(long id);

    List<Subject> findAll();

    Subject findById(long id);
}
