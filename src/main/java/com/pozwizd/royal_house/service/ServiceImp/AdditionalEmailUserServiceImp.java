package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.AdditionalEmailUser;
import com.pozwizd.royal_house.repository.AdditionalEmailUserRepository;
import com.pozwizd.royal_house.service.AdditionalEmailUserService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdditionalEmailUserServiceImp implements AdditionalEmailUserService {

    private final AdditionalEmailUserRepository  additionalEmailUserRepository;

    public AdditionalEmailUserServiceImp(AdditionalEmailUserRepository additionalEmailUserRepository) {
        this.additionalEmailUserRepository = additionalEmailUserRepository;
    }


    @Override
    public void save(AdditionalEmailUser additionalEmailUser) {
        additionalEmailUserRepository.save(additionalEmailUser);
    }

    @Override
    public void delete(long id) {
        additionalEmailUserRepository.deleteById(id);
    }

    @Override
    public void update(AdditionalEmailUser additionalEmailUser) {
        additionalEmailUserRepository.save(additionalEmailUser);
    }

    @Override
    public List<AdditionalEmailUser> findAll() {
        return additionalEmailUserRepository.findAll();
    }

    @Override
    public AdditionalEmailUser findById(long id) {
        return additionalEmailUserRepository.findById(id).orElse(null);
    }
}
