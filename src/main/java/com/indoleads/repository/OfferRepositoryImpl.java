package com.indoleads.repository;

import com.indoleads.domain.offer.Offer;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public List<Offer> findOffersByCategoryId(String input) {
        Query query = entityManager.createNativeQuery("SELECT * FROM offer " +

                "WHERE name LIKE ?", Offer.class);

        query.setParameter(1, "%" + input + "%");

        return query.getResultList();
    }

    @Override
    public List<Offer> findDiscountedOffers(int amount) {
        Query query = entityManager.createNativeQuery("SELECT *, ROUND((1 - (price / oldprice))*100,2) discountpercentage " +
                "FROM offer " +
                "WHERE offer_id IN (SELECT offer_id FROM picture GROUP BY offer_id HAVING count(*)>3) AND price < oldprice " +
                "ORDER BY discountpercentage DESC " +
                "LIMIT ?", Offer.class);
        query.setParameter(1,  amount);

        return query.getResultList();
    }

    @Override
    public List<Offer> findOffersByPrice(int amount) {
        Query query = entityManager.createNativeQuery("SELECT *, ROUND((1 - (price / oldprice))*100,2) discountpercentage " +
                "FROM offer " +
                "WHERE offer_id IN (SELECT offer_id FROM picture GROUP BY offer_id HAVING count(*)>3) AND price < oldprice " +
                "ORDER BY discountpercentage DESC " +
                "LIMIT ?", Offer.class);
        query.setParameter(1,  amount);

        return query.getResultList();
    }

}
