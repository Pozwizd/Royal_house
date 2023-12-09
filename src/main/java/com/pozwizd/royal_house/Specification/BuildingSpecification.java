package com.pozwizd.royal_house.Specification;

import com.pozwizd.royal_house.model.Building;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
public class BuildingSpecification implements Specification<Building> {

    private String name;
    private String address;


    public Predicate toPredicate(Root<Building> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        Predicate p = criteriaBuilder.conjunction();

        if (name != null) {
            p = criteriaBuilder.and(p, criteriaBuilder.like(root.get("name"), "%" + name + "%"));
        }

        if (address != null) {
            p = criteriaBuilder.and(p, criteriaBuilder.like(root.get("address"), "%" + address + "%"));
        }

        return p;

    }

}
