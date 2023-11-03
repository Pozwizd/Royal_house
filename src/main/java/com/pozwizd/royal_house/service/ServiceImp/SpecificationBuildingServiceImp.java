package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.SpecificationBuilding;
import com.pozwizd.royal_house.repository.SpecificationBuildingRepository;
import com.pozwizd.royal_house.service.SpecificationBuildingService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpecificationBuildingServiceImp implements SpecificationBuildingService {

    private final SpecificationBuildingRepository specificationBuildingRepository;

    public SpecificationBuildingServiceImp(SpecificationBuildingRepository specificationBuildingRepository) {
        this.specificationBuildingRepository = specificationBuildingRepository;
    }

    @Override
    public void saveSpecificationBuilding(SpecificationBuilding specificationBuilding) {
        specificationBuildingRepository.save(specificationBuilding);
    }

    @Override
    public SpecificationBuilding getSpecificationBuilding(long id) {
        return specificationBuildingRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSpecificationBuilding(long id) {
        specificationBuildingRepository.deleteById(id);
    }

    @Override
    public void updateSpecificationBuilding(SpecificationBuilding specificationBuilding) {
        specificationBuildingRepository.save(specificationBuilding);
    }

    @Override
    public List<SpecificationBuilding> findAllSpecificationBuildings() {
        return specificationBuildingRepository.findAll();
    }
}
