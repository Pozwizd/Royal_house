package com.pozwizd.royal_house.criteria;

import com.pozwizd.royal_house.model.Requests;
import com.pozwizd.royal_house.model.RequestsPage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class RequestsCriteriaRepository {

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public RequestsCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Page<Requests> findAllWithFilters(RequestsPage requestsPage,
                                             RequestsSearchCriteria requestsSearchCriteria){
        CriteriaQuery<Requests> criteriaQuery = criteriaBuilder.createQuery(Requests.class);
        Root<Requests> requestsRoot = criteriaQuery.from(Requests.class);
        Predicate predicate = getPredicate(requestsSearchCriteria, requestsRoot);
        criteriaQuery.where(predicate);
        setOrder(requestsPage, criteriaQuery, requestsRoot);

        TypedQuery<Requests> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(requestsPage.getPageNumber() * requestsPage.getPageSize());
        typedQuery.setMaxResults(requestsPage.getPageSize());

        Pageable pageable = getPageable(requestsPage);

        long requestsCount = getRequestsCount(predicate);

        return new PageImpl<>(typedQuery.getResultList(), pageable, requestsCount);
    }

    private Predicate getPredicate(RequestsSearchCriteria requestsSearchCriteria,
                                   Root<Requests> requestsRoot) {
        List<Predicate> predicates = new ArrayList<>();
        if(Objects.nonNull(requestsSearchCriteria.getName())){
            predicates.add(
                    criteriaBuilder.like(requestsRoot.get("name"),
                            "%" + requestsSearchCriteria.getName() + "%")
            );
        }
        if(Objects.nonNull(requestsSearchCriteria.getPhoneNumber())){
            predicates.add(
                    criteriaBuilder.like(requestsRoot.get("phoneNumber"),
                            "%" + requestsSearchCriteria.getPhoneNumber() + "%")
            );
        }
        if(Objects.nonNull(requestsSearchCriteria.getEmail())){
            predicates.add(
                    criteriaBuilder.like(requestsRoot.get("email"),
                            "%" + requestsSearchCriteria.getEmail() + "%")
            );
        }
        if(Objects.nonNull(requestsSearchCriteria.getStatus())){
            predicates.add(
                    criteriaBuilder.equal(requestsRoot.get("status"), requestsSearchCriteria.getStatus())
            );
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private void setOrder(RequestsPage requestsPage,
                          CriteriaQuery<Requests> criteriaQuery,
                          Root<Requests> requestsRoot) {
        if(requestsPage.getSortDirection().equals(Sort.Direction.ASC)){
            criteriaQuery.orderBy(criteriaBuilder.asc(requestsRoot.get(requestsPage.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(requestsRoot.get(requestsPage.getSortBy())));
        }
    }

    private Pageable getPageable(RequestsPage requestsPage) {
        Sort sort = Sort.by(requestsPage.getSortDirection(), requestsPage.getSortBy());
        return PageRequest.of(requestsPage.getPageNumber(),requestsPage.getPageSize(), sort);
    }

    private long getRequestsCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Requests> countRoot = countQuery.from(Requests.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }

}
