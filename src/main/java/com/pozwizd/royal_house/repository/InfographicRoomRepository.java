package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.InfographicRoom;
import com.pozwizd.royal_house.model.RoomBuilding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfographicRoomRepository extends JpaRepository<InfographicRoom, Long> {

    List<InfographicRoom> findAllByRoomBuilding(RoomBuilding roomBuilding);
}