package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.RoomBuilding;
import com.pozwizd.royal_house.repository.RoomBuildingRepository;
import com.pozwizd.royal_house.service.RoomBuildingService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomBuildingServiceImp implements RoomBuildingService {

    private final RoomBuildingRepository roomBuildingRepository;

    public RoomBuildingServiceImp(RoomBuildingRepository roomBuildingRepository) {
        this.roomBuildingRepository = roomBuildingRepository;
    }

    @Override
    public void saveRoomBuilding(RoomBuilding roomBuilding) {
        roomBuildingRepository.save(roomBuilding);
    }

    @Override
    public RoomBuilding getRoomBuilding(long id) {
        return roomBuildingRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRoomBuilding(long id) {
        roomBuildingRepository.deleteById(id);
    }

    @Override
    public void updateRoomBuilding(RoomBuilding roomBuilding) {
        roomBuildingRepository.save(roomBuilding);
    }

    @Override
    public List<RoomBuilding> getAllRoomBuildings() {
        return roomBuildingRepository.findAll();
    }
}
