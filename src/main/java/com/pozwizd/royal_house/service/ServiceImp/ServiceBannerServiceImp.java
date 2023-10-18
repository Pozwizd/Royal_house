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
    public void saveServiceBanner(ServiceBanner serviceBanner) {
        serviceBannerRepository.save(serviceBanner);
    }

    @Override
    public ServiceBanner getServiceBanner(long id) {
        return serviceBannerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteServiceBanner(long id) {
        serviceBannerRepository.deleteById(id);
    }

    @Override
    public void updateServiceBanner(ServiceBanner serviceBanner) {
        serviceBannerRepository.save(serviceBanner);
    }

    @Override
    public List<ServiceBanner> getAllServiceBanners() {
        return serviceBannerRepository.findAll();
    }
}
