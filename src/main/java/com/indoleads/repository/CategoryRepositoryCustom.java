package com.indoleads.repository;

import com.indoleads.domain.category.Category;

import java.util.List;

public interface CategoryRepositoryCustom {
    List<Category> findMainCategories(String parent_category);

}
