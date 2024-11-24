package com.product.test.repository;

import com.product.test.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Salerepository extends JpaRepository<Sale, Integer> {

    Sale findByProductId (int productId);
    double findPriceByProductId(int productId);
}