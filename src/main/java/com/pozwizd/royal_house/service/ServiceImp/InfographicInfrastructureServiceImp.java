package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.InfographicInfrastructure;
import com.pozwizd.royal_house.repository.InfographicInfrastructureRepository;
import com.pozwizd.royal_house.service.InfographicInfrastructureService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InfographicInfrastructureServiceImp implements InfographicInfrastructureService {

    private final InfographicInfrastructureRepository  infographicInfrastructureRepository;

    public InfographicInfrastructureServiceImp(InfographicInfrastructureRepository infographicInfrastructureRepository) {
        this.infographicInfrastructureRepository = infographicInfrastructureRepository;
    }

    @Override
    public void saveInfographicInfrastructure(InfographicInfrastructure infographicInfrastructure) {
        infographicInfrastructureRepository.save(infographicInfrastructure);
    }

    @Override
    public InfographicInfrastructure getInfographicInfrastructure(long id) {
        return infographicInfrastructureRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteInfographicInfrastructure(long id) {
        infographicInfrastructureRepository.deleteById(id);
    }

    @Override
    public void updateInfographicInfrastructure(InfographicInfrastructure infographicInfrastructure) {
        infographicInfrastructureRepository.save(infographicInfrastructure);
    }

    @Override
    public List<InfographicInfrastructure> findAllInfographicInfrastructures() {
        return infographicInfrastructureRepository.findAll();
    }
}
