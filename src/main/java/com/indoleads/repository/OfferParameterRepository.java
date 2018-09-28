package com.indoleads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferParameterRepository extends JpaRepository<OfferParameterRepository, Integer> {
}
