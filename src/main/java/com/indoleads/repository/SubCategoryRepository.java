package com.indoleads.repository;

import com.indoleads.domain.category.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<Subcategory, Integer> {
}
