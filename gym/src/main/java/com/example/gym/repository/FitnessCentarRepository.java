package com.example.gym.repository;
import com.example.gym.entity.FitnessCentar;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface FitnessCentarRepository extends JpaRepository<FitnessCentar, Long> {
	
	 List<FitnessCentar> findByNaziv(String naziv);

	  
	 List<FitnessCentar> findByAdresa(String adresa);

	

}
