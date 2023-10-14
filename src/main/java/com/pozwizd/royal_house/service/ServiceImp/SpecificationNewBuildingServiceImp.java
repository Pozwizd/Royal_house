package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.SpecificationNewBuilding;
import com.pozwizd.royal_house.repository.SpecificationNewBuildingRepository;
import com.pozwizd.royal_house.service.SpecificationNewBuildingService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpecificationNewBuildingServiceImp implements SpecificationNewBuildingService {

    private final SpecificationNewBuildingRepository specificationNewBuildingRepository;

    public SpecificationNewBuildingServiceImp(SpecificationNewBuildingRepository specificationNewBuildingRepository) {
        this.specificationNewBuildingRepository = specificationNewBuildingRepository;
    }


    @Override
    public void save(SpecificationNewBuilding specificationNewBuilding) {
        specificationNewBuildingRepository.save(specificationNewBuilding);
    }

    @Override
    public void deleteById(Long id) {
        specificationNewBuildingRepository.deleteById(id);
    }

    @Override
    public void update(SpecificationNewBuilding specificationNewBuilding) {
        specificationNewBuildingRepository.save(specificationNewBuilding);
    }

    @Override
    public List<SpecificationNewBuilding> findAll() {
        return specificationNewBuildingRepository.findAll();
    }

    @Override
    public SpecificationNewBuilding findById(long id) {
        return specificationNewBuildingRepository.findById(id).orElse(null);
    }
}
