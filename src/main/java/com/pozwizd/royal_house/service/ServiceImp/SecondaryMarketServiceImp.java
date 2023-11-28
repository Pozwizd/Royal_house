package com.pozwizd.royal_house.service.ServiceImp;

import com.pozwizd.royal_house.model.SecondaryMarket;
import com.pozwizd.royal_house.repository.SecondaryMarketRepository;
import com.pozwizd.royal_house.service.SecondaryMarketService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SecondaryMarketServiceImp implements SecondaryMarketService {

    private final SecondaryMarketRepository secondaryMarketRepository;

    @Override
    public void addSecondaryMarket(SecondaryMarket secondaryMarket) {
        secondaryMarketRepository.save(secondaryMarket);
    }

    @Override
    public void removeSecondaryMarket(SecondaryMarket secondaryMarket) {
        secondaryMarketRepository.delete(secondaryMarket);
    }

    @Override
    public void updateSecondaryMarket(SecondaryMarket secondaryMarket) {
        secondaryMarketRepository.save(secondaryMarket);
    }

    @Override
    public List<SecondaryMarket> getAllSecondaryMarkets() {
        return secondaryMarketRepository.findAll();
    }

    @Override
    public SecondaryMarket getSecondaryMarket(long id) {
        return secondaryMarketRepository.findById(id).orElse(null);
    }
}
