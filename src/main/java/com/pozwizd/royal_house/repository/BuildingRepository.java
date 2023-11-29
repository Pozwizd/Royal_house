package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.Building;
import com.pozwizd.royal_house.model.StatusBuilding;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends CrudRepository<Building, Long> {
    
    Page<Building> findAll(Specification<Building> spec, Pageable pageable);

    Page<Building> findAll(Pageable pageable);

    List<Building> findAll();
}