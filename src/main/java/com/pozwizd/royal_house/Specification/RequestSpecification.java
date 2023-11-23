package com.pozwizd.royal_house.Specification;

import com.pozwizd.royal_house.model.Requests;
import com.pozwizd.royal_house.model.StatusRequests;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class RequestSpecification implements Specification<Requests> {

    private String name;
    private String phone;
    private String email;

    public RequestSpecification(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Predicate toPredicate(Root<Requests> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        Predicate p = cb.conjunction();

        if(name != null) {
            p = cb.and(p, cb.like(root.get("name"), "%" + name + "%"));
        }

        if(phone != null) {
            p = cb.and(p, cb.like(root.get("phoneNumber"), "%" + phone + "%"));
        }

        if (email != null){
            p = cb.and(p, cb.like(root.get("email"), "%" + email + "%"));
        }

        return p;
    }

}