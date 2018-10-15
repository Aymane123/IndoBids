package com.indoleads.repository;

import com.indoleads.domain.offer.Offer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class OfferRepositoryImpl implements OfferRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Offer> findSearchedOffers(String input) {
        Query query = entityManager.createNativeQuery("SELECT * FROM offer " +

                "WHERE name LIKE ?", Offer.class);

        query.setParameter(1, "%" + input + "%");

        return query.getResultList();
    }
}
