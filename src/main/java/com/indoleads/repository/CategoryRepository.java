package com.indoleads.repository;

import com.indoleads.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    //Category findByCategoryId(String categoryId); //TE VERANDEREN!!!
    List<Category> findByCategoryId(String categoryId);
}
