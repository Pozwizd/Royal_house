package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.Requests;
import com.pozwizd.royal_house.model.StatusRequests;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestsRepository extends JpaRepository<Requests, Long>, PagingAndSortingRepository<Requests, Long> {

    Page<Requests> findAll(Specification<Requests> spec, Pageable pageable);
}