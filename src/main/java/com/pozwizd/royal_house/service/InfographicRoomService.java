package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.InfographicRoom;

import java.util.List;

public interface InfographicRoomService {
    // crud

    void create(InfographicRoom infographicRoom);

    void update(InfographicRoom infographicRoom);

    void delete(long id);

    List<InfographicRoom> findAll();

    InfographicRoom findById(long id);
}
