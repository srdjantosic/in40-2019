package com.example.gym.repository;
import com.example.gym.entity.Trening;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface TreningRepository extends JpaRepository<Trening, Long>{
	
	
	
	List<Trening> findByOrderByCenaAsc ();
	
	@Query("Select t from Trening t join fetch t.termini")
	List<Trening> findTreningSort ();
	
	
}
