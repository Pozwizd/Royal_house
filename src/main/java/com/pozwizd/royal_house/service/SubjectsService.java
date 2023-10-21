package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.Subjects;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubjectsService {

    public void saveSubjects(Subjects subjects);

    public Subjects getSubjects(Long id);

    public void deleteSubjects(long id);

    public void deleteAllSubjects();

    public List<Subjects> findAllSubjects();

    Page<Subjects> findByRequest(Long id, String propertyType, Integer rooms, Pageable pageable);
}
