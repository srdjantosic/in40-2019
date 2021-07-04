package com.example.gym.repository;

import com.example.gym.entity.FitnessCentar;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface FitnessCentarRepository extends JpaRepository<FitnessCentar, Long> {
	
	 List<FitnessCentar> findByNaziv(String naziv);

	  
	 List<FitnessCentar> findByAdresa(String adresa);
	 List<FitnessCentar> findAll();
	 
	@Query("Select f from FitnessCentar f where f.naziv=?1")
	FitnessCentar nadjiNaziv(String naziv);
	

}
