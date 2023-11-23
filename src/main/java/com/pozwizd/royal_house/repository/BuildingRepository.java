package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.Building;
import com.pozwizd.royal_house.model.StatusBuilding;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BuildingRepository extends CrudRepository<Building, Long> {

    @Query("SELECT b FROM Building b " +
            "WHERE (:name IS NULL OR b.name = :name) " +
            "AND (:address IS NULL OR b.address = :address) " +
            "AND (:status IS NULL OR b.statusBuilding = :status) ")
    Page<Building> findByCriteria(@Param("name") String name,
                                  @Param("address") String address,
                                  @Param("status") StatusBuilding status,
                                  Pageable pageable);

    @Query("SELECT b FROM Building b " +
            "WHERE (:name IS NULL OR b.name = :name) ")
    Page<Building> findByName(@Param("name") String name,
                                  Pageable pageable);
}