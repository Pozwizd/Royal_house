package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.RoomBuilding;

import java.util.List;

public interface RoomBuildingService {

    public void saveRoomBuilding(RoomBuilding roomBuilding);

    public RoomBuilding getRoomBuilding(long id);

    public void deleteRoomBuilding(long id);

    public void updateRoomBuilding(RoomBuilding roomBuilding);

    public List<RoomBuilding> getAllRoomBuildings();

}
