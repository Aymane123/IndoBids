package com.indoleads.repository;

import com.indoleads.domain.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
    Shop findFirstByOrderByIdAsc();
}
