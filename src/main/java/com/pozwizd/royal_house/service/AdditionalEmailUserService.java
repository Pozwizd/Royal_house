package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.AdditionalEmailUser;

import java.util.List;

public interface AdditionalEmailUserService {
    // Crud operations

    void save(AdditionalEmailUser additionalEmailUser);

    void delete(long id);

    void update(AdditionalEmailUser additionalEmailUser);

    List<AdditionalEmailUser> findAll();

    AdditionalEmailUser findById(long id);

}
