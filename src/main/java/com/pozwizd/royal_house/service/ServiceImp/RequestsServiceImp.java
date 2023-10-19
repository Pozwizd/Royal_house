package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.criteria.RequestsCriteriaRepository;
import com.pozwizd.royal_house.criteria.RequestsSearchCriteria;
import com.pozwizd.royal_house.model.Requests;
import com.pozwizd.royal_house.model.RequestsPage;
import com.pozwizd.royal_house.repository.RequestsRepository;
import com.pozwizd.royal_house.service.RequestsService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public class RequestsServiceImp implements RequestsService {


    private final RequestsRepository requestsRepository;
    private final RequestsCriteriaRepository requestsCriteriaRepository;

    public RequestsServiceImp(RequestsRepository requestsRepository, RequestsCriteriaRepository requestsCriteriaRepository) {
        this.requestsRepository = requestsRepository;
        this.requestsCriteriaRepository = requestsCriteriaRepository;
    }


    public Page<Requests> getAllRequests(RequestsPage requestsPage,
                                       RequestsSearchCriteria requestsSearchCriteria){
        return requestsCriteriaRepository.findAllWithFilters(requestsPage, requestsSearchCriteria);
    }

    public Requests saveRequests(Requests employee){
        return requestsRepository.save(employee);
    }
}
