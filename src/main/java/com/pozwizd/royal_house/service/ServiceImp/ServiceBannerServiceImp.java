package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.ServiceBanner;
import com.pozwizd.royal_house.repository.ServiceBannerRepository;
import com.pozwizd.royal_house.service.ServiceBannerService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceBannerServiceImp implements ServiceBannerService {

    private final ServiceBannerRepository serviceBannerRepository;

    public ServiceBannerServiceImp(ServiceBannerRepository serviceBannerRepository) {
        this.serviceBannerRepository = serviceBannerRepository;
    }

    @Override
    public void save(ServiceBanner serviceBanner) {
        serviceBannerRepository.save(serviceBanner);
    }

    @Override
    public void delete(ServiceBanner serviceBanner) {
        serviceBannerRepository.delete(serviceBanner);
    }

    @Override
    public void deleteById(Long id) {
        serviceBannerRepository.deleteById(id);
    }

    @Override
    public List<ServiceBanner> findAll() {
        return serviceBannerRepository.findAll();
    }

    @Override
    public ServiceBanner findById(long id) {
        return serviceBannerRepository.findById(id).orElse(null);
    }
}
