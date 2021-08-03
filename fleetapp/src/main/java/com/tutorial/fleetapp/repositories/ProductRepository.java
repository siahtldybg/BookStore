package com.tutorial.fleetapp.repositories;

import com.tutorial.fleetapp.models.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("SELECT p FROM Product p WHERE p.author like %:keyword% OR p.bookname like %:keyword% OR p.producttype.category like %:keyword% OR p.producttype.type like %:keyword% OR p.price like %:keyword%")
	public List<Product> getByBookname(@Param("keyword") String keyword);
//	FROM Product p WHERE p.name LIKE :kw OR p.category.name LIKE :kw OR p.category.nameVN LIKE :kw

}
