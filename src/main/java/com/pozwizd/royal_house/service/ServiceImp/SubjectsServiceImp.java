package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.Subjects;
import com.pozwizd.royal_house.repository.SubjectsRepository;
import com.pozwizd.royal_house.service.SubjectsService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectsServiceImp implements SubjectsService {

    private final SubjectsRepository subjectsRepository;

    public SubjectsServiceImp(SubjectsRepository subjectsRepository) {
        this.subjectsRepository = subjectsRepository;
    }

    @Override
    public void saveSubjects(Subjects subjects) {
        subjectsRepository.save(subjects);
    }

    @Override
    public Subjects getSubjects(Long id) {
        return subjectsRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSubjects(long id) {
        subjectsRepository.deleteById(id);
    }

    @Override
    public void deleteAllSubjects() {
        subjectsRepository.deleteAll();
    }

    @Override
    public List<Subjects> findAllSubjects() {
        return subjectsRepository.findAll();
    }
}
