package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.Requests;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestsRepository extends JpaRepository<Requests, Long>, PagingAndSortingRepository<Requests, Long> {

    @Override
    Page<Requests> findAll(Pageable pageable);
}