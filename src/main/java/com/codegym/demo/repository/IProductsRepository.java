package com.codegym.demo.repository;

import com.codegym.demo.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductsRepository extends JpaRepository<Products,Long> {
 public Iterable<Products> findProductsByNameContaining(String Name);
}
