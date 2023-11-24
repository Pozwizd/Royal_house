package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.Services;
import com.pozwizd.royal_house.model.Visible;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {

    @Query(value = "SELECT s FROM Services s WHERE (:name IS NULL OR s.name LIKE %:name%) ")
    Page<Services> findByCriteria(@Param("name") String name,
                                  Pageable pageable);
}