package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.AdditionalEmail;

import java.util.List;

public interface AdditionalEmailService {

    public void saveAdditionalEmail(AdditionalEmail additionalEmail);

    public AdditionalEmail getAdditionalEmail(long id);

    public void deleteAdditionalEmail(long id);

    public void updateAdditionalEmail(AdditionalEmail additionalEmail);


    public List<AdditionalEmail> getAllAdditionalEmails();

}

