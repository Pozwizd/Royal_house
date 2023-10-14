package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.Inquiry;

import java.util.List;

public interface InquiryService {
    // Crud operations
    void save(Inquiry inquiry);

    void delete(long id);

    void update(Inquiry inquiry);

    List<Inquiry> findAll();

    Inquiry findById(long id);
}
