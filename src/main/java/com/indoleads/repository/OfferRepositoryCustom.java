package com.indoleads.repository;

import com.indoleads.domain.offer.Offer;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface OfferRepositoryCustom {
    List<Offer> findSearchedOffers(String input);

    List<Offer> findOffersByCategoryId(String id);

    List<Offer> findDiscountedOffers(int amount);

}
