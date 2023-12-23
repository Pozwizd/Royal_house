package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.InfographicRoom;
import com.pozwizd.royal_house.model.RoomBuilding;
import com.pozwizd.royal_house.repository.InfographicRoomRepository;
import com.pozwizd.royal_house.service.InfographicRoomService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InfographicRoomServiceImp implements InfographicRoomService {

    private final InfographicRoomRepository infographicRoomRepository;

    public InfographicRoomServiceImp(InfographicRoomRepository infographicRoomRepository) {
        this.infographicRoomRepository = infographicRoomRepository;
    }


    @Override
    public void saveInfographicRoom(InfographicRoom infographicRoom) {
        infographicRoomRepository.save(infographicRoom);
    }

    @Override
    public InfographicRoom getInfographicRoom(long id) {
        return infographicRoomRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteInfographicRoom(long id) {
        infographicRoomRepository.deleteById(id);
    }

    @Override
    public void updateInfographicRoom(InfographicRoom infographicRoom) {
        infographicRoomRepository.save(infographicRoom);
    }

    @Override
    public List<InfographicRoom> findAllInfographicRooms() {
        return infographicRoomRepository.findAll();
    }

    @Override
    public List<InfographicRoom> findAllByRoomBuilding(RoomBuilding roomBuilding){
        return infographicRoomRepository.findAllByRoomBuilding(roomBuilding);
    }
}
