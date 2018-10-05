package com.indoleads.service;

import com.indoleads.domain.shop.Shop;
import com.indoleads.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    private ShopRepository shopRepository;

    @Autowired
    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Shop getShop() {
        Shop shop = shopRepository.findFirstByOrderByIdAsc();

        if (shop != null){
            return shop;
        }
        return null;
    }
}
