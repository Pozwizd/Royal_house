package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.Service;
import com.pozwizd.royal_house.repository.ServiceRepository;
import com.pozwizd.royal_house.service.ServiceService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceServiceImp implements ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceServiceImp(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void delete(long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public void update(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Service findById(long id) {
        return serviceRepository.findById(id).orElse(null);
    }
}
