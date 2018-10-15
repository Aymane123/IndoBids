package com.indoleads.repository;

import com.indoleads.domain.offer.Offer;

import java.util.List;

public interface OfferRepositoryCustom {
    List<Offer> findSearchedOffers(String input);
}
