package com.pozwizd.royal_house.service;

import com.pozwizd.royal_house.model.SecondaryMarket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SecondaryMarketService {

    public void addSecondaryMarket(SecondaryMarket secondaryMarket);

    public void removeSecondaryMarket(SecondaryMarket secondaryMarket);

    public void updateSecondaryMarket(SecondaryMarket secondaryMarket);

    public List<SecondaryMarket> getAllSecondaryMarkets();

    public SecondaryMarket getSecondaryMarket(long id);

}
