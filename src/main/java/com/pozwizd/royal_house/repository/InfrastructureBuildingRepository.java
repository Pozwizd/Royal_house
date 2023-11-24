package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.InfrastructureBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InfrastructureBuildingRepository extends JpaRepository<InfrastructureBuilding, Long> {
}