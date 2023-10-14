package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.InfographicInfrastructure;
import com.pozwizd.royal_house.repository.InfographicInfrastructureRepository;
import com.pozwizd.royal_house.service.InfographicInfrastructureService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InfographicInfrastructureServiceImp implements InfographicInfrastructureService {

    private final InfographicInfrastructureRepository infographicInfrastructureRepository;

    public InfographicInfrastructureServiceImp(InfographicInfrastructureRepository infographicInfrastructureRepository) {
        this.infographicInfrastructureRepository = infographicInfrastructureRepository;
    }

    @Override
    public void save(InfographicInfrastructure infographicInfrastructure) {
        infographicInfrastructureRepository.save(infographicInfrastructure);
    }

    @Override
    public void delete(long id) {
        infographicInfrastructureRepository.deleteById(id);
    }

    @Override
    public void update(InfographicInfrastructure infographicInfrastructure) {
        infographicInfrastructureRepository.save(infographicInfrastructure);
    }

    @Override
    public List<InfographicInfrastructure> findAll() {
        return infographicInfrastructureRepository.findAll();
    }

    @Override
    public InfographicInfrastructure findById(long id) {
        return infographicInfrastructureRepository.findById(id).orElse(null);
    }
}
