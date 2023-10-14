package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.PanoramaNewBuilding;
import com.pozwizd.royal_house.repository.PanoramaNewBuildingRepository;
import com.pozwizd.royal_house.service.PanoramaNewBuildingService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PanoramaNewBuildingServiceImp implements PanoramaNewBuildingService {

    private final PanoramaNewBuildingRepository panoramaNewBuildingRepository;

    public PanoramaNewBuildingServiceImp(PanoramaNewBuildingRepository panoramaNewBuildingRepository) {
        this.panoramaNewBuildingRepository = panoramaNewBuildingRepository;
    }


    @Override
    public void save(PanoramaNewBuilding panoramaNewBuilding) {
        panoramaNewBuildingRepository.save(panoramaNewBuilding);
    }

    @Override
    public void delete(long id) {
        panoramaNewBuildingRepository.deleteById(id);
    }

    @Override
    public void deleteById(Long id) {
        panoramaNewBuildingRepository.deleteById(id);
    }

    @Override
    public List<PanoramaNewBuilding> findAll() {
        return panoramaNewBuildingRepository.findAll();
    }

    @Override
    public PanoramaNewBuilding findById(long id) {
        return panoramaNewBuildingRepository.findById(id).orElse(null);
    }
}
