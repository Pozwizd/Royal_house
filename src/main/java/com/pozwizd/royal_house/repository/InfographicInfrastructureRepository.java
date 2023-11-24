package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.InfographicInfrastructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfographicInfrastructureRepository extends JpaRepository<InfographicInfrastructure, Long> {
}