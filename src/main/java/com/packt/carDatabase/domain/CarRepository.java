package com.packt.carDatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long>{
	
	// define query but must start findBy
	@Query("select c from Car c where c.brand = ?1 ")
	List<Car> findByBrand(String brand);
	
	List<Car> findByColor(String color);
	
	List<Car> findByYear(int year);
	
	// define query with multiple field
	List<Car> findByBrandAndModel(String brand, String model);
	
	List<Car> findByBrandOrColor(String brand, String color);
	
	List<Car> findByBrandOrderByYearAsc(String brand);
	
	@Query("select c from Car c where c.brand like %?1 ")
	List<Car> findByBrandEndsWith(String brand);
	
}
