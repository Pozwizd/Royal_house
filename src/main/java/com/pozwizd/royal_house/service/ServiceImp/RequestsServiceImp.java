package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.Specification.RequestSpecification;
import com.pozwizd.royal_house.model.Requests;
import com.pozwizd.royal_house.model.StatusRequests;
import com.pozwizd.royal_house.repository.RequestsRepository;
import com.pozwizd.royal_house.service.RequestsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

@Repository
public class RequestsServiceImp implements RequestsService {

    private final RequestsRepository requestsRepository;

    public RequestsServiceImp(RequestsRepository requestsRepository) {
        this.requestsRepository = requestsRepository;
    }

    @Override
    public void saveRequests(Requests requests) {
        requestsRepository.save(requests);
    }

    @Override
    public Requests getRequests(long id) {
        return requestsRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRequests(long id) {
        requestsRepository.deleteById(id);
    }

    @Override
    public void updateRequests(Requests requests) {
        requestsRepository.save(requests);
    }

    @Override
    public Page<Requests> findAll(Pageable pageable) {
        return requestsRepository.findAll(pageable);
    }

    @Override
    public Page<Requests> findByRequest(String name,
                                        String phoneNumber,
                                        String email,
//                                        StatusRequests status,
                                        Pageable pageable) {
        Specification<Requests> spec = new RequestSpecification(name,
                phoneNumber,
                email
//                status
        );

        return requestsRepository.findAll(spec, pageable);
    }
}
