package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.Building;
import com.pozwizd.royal_house.model.InfrastructureBuilding;
import com.pozwizd.royal_house.repository.InfrastructureBuildingRepository;
import com.pozwizd.royal_house.service.InfrastructureBuildingService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InfrastructureBuildingServiceImp implements InfrastructureBuildingService {

    private final InfrastructureBuildingRepository infrastructureBuildingRepository;

    public InfrastructureBuildingServiceImp(InfrastructureBuildingRepository infrastructureBuildingRepository) {
        this.infrastructureBuildingRepository = infrastructureBuildingRepository;
    }

    @Override
    public void saveInfrastructureBuilding(InfrastructureBuilding infrastructureBuilding) {
        infrastructureBuildingRepository.save(infrastructureBuilding);
    }

    @Override
    public InfrastructureBuilding getInfrastructureBuilding(long id) {
        return infrastructureBuildingRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteInfrastructureBuilding(long id) {
        infrastructureBuildingRepository.deleteById(id);
    }

    @Override
    public void updateInfrastructureBuilding(InfrastructureBuilding infrastructureBuilding) {
        infrastructureBuildingRepository.save(infrastructureBuilding);
    }

    @Override
    public List<InfrastructureBuilding> findAllInfrastructureBuildings() {
        return infrastructureBuildingRepository.findAll();
    }

    public InfrastructureBuilding findByBuildingId(Building building) {
        return infrastructureBuildingRepository.findById(building.getInfrastructureBuilding().getId()).orElse(null);
    }
}
