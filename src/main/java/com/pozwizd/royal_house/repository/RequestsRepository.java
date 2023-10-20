package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.Requests;
import com.pozwizd.royal_house.model.Status;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestsRepository extends JpaRepository<Requests, Long>, PagingAndSortingRepository<Requests, Long> {

    @Query("SELECT r FROM Requests r " +
            "WHERE (:name IS NULL OR r.name LIKE %:name%) " +
            "AND (:phoneNumber IS NULL OR r.phoneNumber LIKE %:phoneNumber%) " +
            "AND (:email IS NULL OR r.email LIKE %:email%) " )
    Page<Requests> findByCriteria(@Param("name") String name,
                                  @Param("phoneNumber") String phoneNumber,
                                  @Param("email") String email,
                                  Pageable pageable);
}