package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.ServiceBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceBannerRepository extends JpaRepository<ServiceBanner, Long> {
}