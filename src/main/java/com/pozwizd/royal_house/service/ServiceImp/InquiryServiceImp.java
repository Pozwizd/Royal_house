package com.pozwizd.royal_house.service.ServiceImp;


import com.pozwizd.royal_house.model.Inquiry;
import com.pozwizd.royal_house.repository.InquiryRepository;
import com.pozwizd.royal_house.service.InquiryService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InquiryServiceImp implements InquiryService {

    private final InquiryRepository inquiryRepository;

    public InquiryServiceImp(InquiryRepository inquiryRepository) {
        this.inquiryRepository = inquiryRepository;
    }

    @Override
    public void save(Inquiry inquiry) {
        inquiryRepository.save(inquiry);
    }

    @Override
    public void delete(long id) {
        inquiryRepository.findById(id);
    }

    @Override
    public void update(Inquiry inquiry) {
        inquiryRepository.save(inquiry);
    }

    @Override
    public List<Inquiry> findAll() {
        return inquiryRepository.findAll();
    }

    @Override
    public Inquiry findById(long id) {
        return inquiryRepository.findById(id).orElse(null);
    }
}
