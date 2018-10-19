package com.indoleads.repository;

import com.indoleads.domain.category.Category;

import java.util.List;

public interface CategoryRepositoryCustom {
    List<Category> findMainCategories(String parent_category);
    List<Category> findCategoriesOfOffer(String offerId);
    List<Category> findParentCategoryForOffer(String offerId);
    List<Category> findChildCategory(String categoryId);
    List<Category> findCategoriesOfOfferByCategoryId(String categoryId);

}
