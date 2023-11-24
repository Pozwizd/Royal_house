package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.AboutCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutCompanyRepository extends JpaRepository<AboutCompany, Long> {
}