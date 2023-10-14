package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.ServiceBanner;

import java.util.List;

public interface ServiceBannerService {
    // Crud operations
    void save(ServiceBanner serviceBanner);

    void delete(ServiceBanner serviceBanner);

    void deleteById(Long id);

    List<ServiceBanner> findAll();

    ServiceBanner findById(long id);
}
