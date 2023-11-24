package com.pozwizd.royal_house.repository;

import com.pozwizd.royal_house.model.Requests;
import com.pozwizd.royal_house.model.Subjects;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectsRepository extends JpaRepository<Subjects, Long>, PagingAndSortingRepository<Subjects, Long> {

    @Query("SELECT s FROM Subjects s " +
            "WHERE (:id IS NULL OR s.id = :id) " +
            "AND (:propertyType IS NULL OR s.propertyType = :propertyType) " +
            "AND (:rooms IS NULL OR s.rooms = :rooms) " )
    Page<Subjects> findByCriteria(@Param("id") Long id,
                                  @Param("propertyType") String propertyType,
                                  @Param("rooms") Integer rooms,
                                  Pageable pageable);
}