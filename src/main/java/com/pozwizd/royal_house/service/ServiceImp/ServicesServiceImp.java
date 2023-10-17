package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.Services;
import com.pozwizd.royal_house.repository.ServicesRepository;
import com.pozwizd.royal_house.service.ServicesService;

import java.util.List;

public class ServicesServiceImp implements ServicesService {

    private final ServicesRepository servicesRepository;

    public ServicesServiceImp(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    @Override
    public void saveServices(Services services) {
        servicesRepository.save(services);
    }

    @Override
    public Services getServices(long id) {
        return servicesRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteServices(long id) {
        servicesRepository.deleteById(id);
    }

    @Override
    public void updateServices(Services services) {
        servicesRepository.save(services);
    }

    @Override
    public List<Services> getAllServices() {
        return servicesRepository.findAll();
    }
}
