package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.Requests;
import com.pozwizd.royal_house.repository.RequestsRepository;
import com.pozwizd.royal_house.service.RequestsService;

import java.util.List;

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
    public List<Requests> findAll() {
        return requestsRepository.findAll();
    }
}
