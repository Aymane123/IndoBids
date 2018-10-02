package com.indoleads.repository;

import com.indoleads.domain.offer.OfferParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferParameterRepository extends JpaRepository<OfferParameter, Integer> {
}
