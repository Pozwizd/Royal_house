package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
}