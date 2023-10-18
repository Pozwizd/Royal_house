package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.InfographicBuilding;
import com.pozwizd.royal_house.repository.InfographicBuildingRepository;
import com.pozwizd.royal_house.service.InfographicBuildingService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InfographicBuildingServiceImp implements InfographicBuildingService {

    private final InfographicBuildingRepository infographicBuildingRepository;

    public InfographicBuildingServiceImp(InfographicBuildingRepository infographicBuildingRepository) {
        this.infographicBuildingRepository = infographicBuildingRepository;
    }

    @Override
    public void saveInfographicBuilding(InfographicBuilding infographicBuilding) {
        infographicBuildingRepository.save(infographicBuilding);
    }

    @Override
    public InfographicBuilding getInfographicBuilding(long id) {
        return infographicBuildingRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteInfographicBuilding(long id) {
        infographicBuildingRepository.deleteById(id);
    }

    @Override
    public void updateInfographicBuilding(InfographicBuilding infographicBuilding) {
        infographicBuildingRepository.save(infographicBuilding);
    }

    @Override
    public List<InfographicBuilding> findAllInfographicBuildings() {
        return infographicBuildingRepository.findAll();
    }
}
