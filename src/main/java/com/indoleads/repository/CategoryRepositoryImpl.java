package com.indoleads.repository;

import com.indoleads.domain.category.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CategoryRepositoryImpl implements CategoryRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Category> findMainCategories(String parent_category) {
        Query query = entityManager.createNativeQuery("SELECT * FROM category " +

                "WHERE parent_category LIKE ?", Category.class);

        query.setParameter(1, parent_category + "%");

        return query.getResultList();
    }

    @Override
    public List<Category> findCategoriesOfOffer(String offerId) {
        Query query = entityManager.createNativeQuery("SELECT * FROM category " +
                "WHERE category_id IN (SELECT category_id FROM offer WHERE id = ?)", Category.class);

        query.setParameter(1, offerId);

        return query.getResultList();
    }

    @Override
    public List<Category> findParentCategoryForOffer(String offerId) {
        Query query = entityManager.createNativeQuery("SELECT * FROM category " +
                "WHERE category_id IN (SELECT parent_category FROM offer WHERE id = ?)", Category.class);

        query.setParameter(1, offerId);

        return query.getResultList();
    }

    @Override
    public List<Category> findChildCategory(String categoryId) {
        Query query = entityManager.createNativeQuery("SELECT * FROM category " +

                "WHERE parent_category LIKE ?", Category.class);

        query.setParameter(1, categoryId + "%");

        return query.getResultList();
    }

    @Override
    public List<Category> findCategoriesOfOfferByCategoryId(String categoryId) {
        Query query = entityManager.createNativeQuery("SELECT * FROM category " +

                "WHERE category_id LIKE ?", Category.class);

        query.setParameter(1, categoryId + "%");

        return query.getResultList();
    }
}
