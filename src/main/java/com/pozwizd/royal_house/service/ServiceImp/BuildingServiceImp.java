package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.Specification.BuildingSpecification;
import com.pozwizd.royal_house.model.Building;
import com.pozwizd.royal_house.model.StatusBuilding;
import com.pozwizd.royal_house.repository.BuildingRepository;
import com.pozwizd.royal_house.service.BuildingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuildingServiceImp implements BuildingService {

    private final BuildingRepository buildingRepository;

    public BuildingServiceImp(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }


    @Override
    public void save(Building building) {
        buildingRepository.save(building);
    }

    @Override
    public void delete(long id) {
        buildingRepository.deleteById(id);
    }

    @Override
    public Building findById(long id) {
        return buildingRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Building building) {
        buildingRepository.save(building);
    }

    @Override
    public List<Building> findAll() {
        return buildingRepository.findAll();
    }



    @Override
    public Page<Building> findByRequest(String name,
                                        String address,
                                        Pageable pageable) {
        Specification<Building> spec = new BuildingSpecification(name, address);
        return buildingRepository.findAll(spec, pageable);
    }



    @Override
    public Page<Building> findAll(Pageable pageable) {

        return buildingRepository.findAll(pageable);
    }

}
