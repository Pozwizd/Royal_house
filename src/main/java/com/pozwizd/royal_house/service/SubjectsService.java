package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.Subjects;

import java.util.List;

public interface SubjectsService {

    public void saveSubjects(Subjects subjects);

    public Subjects getSubjects(Long id);

    public void deleteSubjects(long id);

    public void deleteAllSubjects();

    public List<Subjects> findAllSubjects();

}
