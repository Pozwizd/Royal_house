package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.InfographicNewBuilding;
import com.pozwizd.royal_house.repository.InfographicNewBuildingRepository;
import com.pozwizd.royal_house.service.InfographicNewBuildingService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InfographicNewBuildingServiceImp implements InfographicNewBuildingService {

    private final InfographicNewBuildingRepository  infographicNewBuildingRepository;

    public InfographicNewBuildingServiceImp(InfographicNewBuildingRepository infographicNewBuildingRepository) {
        this.infographicNewBuildingRepository = infographicNewBuildingRepository;
    }

    @Override
    public void save(InfographicNewBuilding infographicNewBuilding) {
        infographicNewBuildingRepository.save(infographicNewBuilding);
    }

    @Override
    public void update(InfographicNewBuilding infographicNewBuilding) {
        infographicNewBuildingRepository.save(infographicNewBuilding);
    }

    @Override
    public void delete(long id) {
        infographicNewBuildingRepository.deleteById(id);
    }

    @Override
    public List<InfographicNewBuilding> findAll() {
        return infographicNewBuildingRepository.findAll();
    }

    @Override
    public InfographicNewBuilding findById(long id) {
        return infographicNewBuildingRepository.findById(id).orElse(null);
    }
}
