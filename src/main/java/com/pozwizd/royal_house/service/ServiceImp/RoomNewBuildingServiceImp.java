package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.RoomNewBuilding;
import com.pozwizd.royal_house.repository.RoomNewBuildingRepository;
import com.pozwizd.royal_house.service.RoomNewBuildingService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomNewBuildingServiceImp implements RoomNewBuildingService {

    private final RoomNewBuildingRepository roomNewBuildingRepository;

    public RoomNewBuildingServiceImp(RoomNewBuildingRepository roomNewBuildingRepository) {
        this.roomNewBuildingRepository = roomNewBuildingRepository;
    }

    @Override
    public void save(RoomNewBuilding roomNewBuilding) {
        roomNewBuildingRepository.save(roomNewBuilding);
    }

    @Override
    public void update(RoomNewBuilding roomNewBuilding) {
        roomNewBuildingRepository.save(roomNewBuilding);
    }

    @Override
    public void delete(long id) {
        roomNewBuildingRepository.deleteById(id);
    }

    @Override
    public List<RoomNewBuilding> findAll() {
        return roomNewBuildingRepository.findAll();
    }

    @Override
    public RoomNewBuilding findById(long id) {
        return roomNewBuildingRepository.findById(id).orElse(null);
    }
}
