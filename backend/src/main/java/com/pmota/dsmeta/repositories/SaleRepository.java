package com.pmota.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pmota.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
		
	// Query JPQA
	String findSales = "SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC";
		
	// Consultas Customizadas 
	@Query(findSales)
	Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);

}
