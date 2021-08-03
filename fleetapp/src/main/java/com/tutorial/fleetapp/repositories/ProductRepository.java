package com.tutorial.fleetapp.repositories;

import com.tutorial.fleetapp.models.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByBookname(String keyword);
	@Query("SELECT p FROM Product p WHERE p.bookname like %:keyword%")
	public List<Product> getByBookName(@Param("keyword") String keyword);
}
