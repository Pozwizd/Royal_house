package com.pozwizd.royal_house.Specification;

import com.pozwizd.royal_house.model.Requests;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class RequestSpecification implements Specification<Requests> {

    private String name;
    private String phone;
    private String email;

//    private StatusRequests status;

    public RequestSpecification(String name,
                                String phone,
                                String email
//                                StatusRequests status
    ) {
        this.name = name;
        this.phone = phone;
        this.email = email;
//        this.status = status;
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

//        // Проверка enum на соответствие
//        if (status != null){
//            p = cb.and(p, cb.equal(root.get("status"), status));
//        }

        return p;
    }

}