package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.InfographicRoom;

import java.util.List;

public interface InfographicRoomService {

    public void saveInfographicRoom(InfographicRoom infographicRoom);

    public InfographicRoom getInfographicRoom(long id);

    public void deleteInfographicRoom(long id);

    public void updateInfographicRoom(InfographicRoom infographicRoom);

    public List<InfographicRoom> findAllInfographicRooms();

}
