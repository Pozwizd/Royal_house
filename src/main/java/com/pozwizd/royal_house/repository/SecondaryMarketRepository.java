package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.SecondaryMarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondaryMarketRepository extends JpaRepository<SecondaryMarket, Long> {
}