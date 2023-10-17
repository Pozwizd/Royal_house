package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.AdditionalEmail;
import com.pozwizd.royal_house.repository.AdditionalEmailRepository;
import com.pozwizd.royal_house.service.AdditionalEmailService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdditionalEmailServiceImp implements AdditionalEmailService {

    private final AdditionalEmailRepository additionalEmailRepository;

    public AdditionalEmailServiceImp(AdditionalEmailRepository additionalEmailRepository) {
        this.additionalEmailRepository = additionalEmailRepository;
    }


    @Override
    public void saveAdditionalEmail(AdditionalEmail additionalEmail) {
        additionalEmailRepository.save(additionalEmail);
    }

    @Override
    public AdditionalEmail getAdditionalEmail(long id) {
        return additionalEmailRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAdditionalEmail(long id) {
        additionalEmailRepository.deleteById(id);
    }

    @Override
    public void updateAdditionalEmail(AdditionalEmail additionalEmail) {
        additionalEmailRepository.save(additionalEmail);
    }

    @Override
    public List<AdditionalEmail> getAllAdditionalEmails() {
        return additionalEmailRepository.findAll();
    }
}
