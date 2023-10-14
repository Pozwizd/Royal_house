package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.InfographicRoom;
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
    public void create(InfographicRoom infographicRoom) {
        infographicRoomRepository.save(infographicRoom);
    }

    @Override
    public void update(InfographicRoom infographicRoom) {
        infographicRoomRepository.save(infographicRoom);
    }

    @Override
    public void delete(long id) {
        infographicRoomRepository.deleteById(id);
    }

    @Override
    public List<InfographicRoom> findAll() {
        return infographicRoomRepository.findAll();
    }

    @Override
    public InfographicRoom findById(long id) {
        return infographicRoomRepository.findById(id).orElse(null);
    }
}
