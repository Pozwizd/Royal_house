package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.LocationNewBuilding;
import com.pozwizd.royal_house.repository.LocationNewBuildingRepository;
import com.pozwizd.royal_house.service.LocationNewBuildingService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationNewBuildingServiceImp implements LocationNewBuildingService {

    private final LocationNewBuildingRepository locationNewBuildingRepository;

    public LocationNewBuildingServiceImp(LocationNewBuildingRepository locationNewBuildingRepository) {
        this.locationNewBuildingRepository = locationNewBuildingRepository;
    }

    @Override
    public void save(LocationNewBuilding locationNewBuilding) {
        locationNewBuildingRepository.save(locationNewBuilding);
    }

    @Override
    public void update(LocationNewBuilding locationNewBuilding) {
        locationNewBuildingRepository.save(locationNewBuilding);
    }

    @Override
    public void delete(long id) {
        locationNewBuildingRepository.deleteById(id);
    }

    @Override
    public List<LocationNewBuilding> findAll() {
        return locationNewBuildingRepository.findAll();
    }

    @Override
    public LocationNewBuilding findById(long id) {
        return locationNewBuildingRepository.findById(id).orElse(null);
    }
}
