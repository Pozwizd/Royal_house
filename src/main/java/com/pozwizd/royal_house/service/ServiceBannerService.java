package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.ServiceBanner;

import java.util.List;

public interface ServiceBannerService {

    public void saveServiceBanner(ServiceBanner serviceBanner);
    public ServiceBanner getServiceBanner(long id);
    public void deleteServiceBanner(long id);
    public void updateServiceBanner(ServiceBanner serviceBanner);

    public List<ServiceBanner> getAllServiceBanners();
}
