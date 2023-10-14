package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.NewBuilding;
import com.pozwizd.royal_house.repository.NewBuildingRepository;
import com.pozwizd.royal_house.service.NewBuildingService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewBuildingServiceImp implements NewBuildingService {

    private final NewBuildingRepository  newBuildingRepository;

    public NewBuildingServiceImp(NewBuildingRepository newBuildingRepository) {
        this.newBuildingRepository = newBuildingRepository;
    }

    @Override
    public void save(NewBuilding newBuilding) {
        newBuildingRepository.save(newBuilding);
    }

    @Override
    public void delete(long id) {
        newBuildingRepository.deleteById(id);
    }

    @Override
    public void update(NewBuilding newBuilding) {
        newBuildingRepository.save(newBuilding);
    }

    @Override
    public List<NewBuilding> findAll() {
        return newBuildingRepository.findAll();
    }

    @Override
    public NewBuilding findById(long id) {
        return newBuildingRepository.findById(id).orElse(null);
    }
}
