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
}
