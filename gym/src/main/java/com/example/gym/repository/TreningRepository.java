package com.example.gym.repository;
import com.example.gym.entity.Trening;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface TreningRepository extends JpaRepository<Trening, Long>{
	
	
	
	List<Trening> findByOrderByCenaAsc ();
	
	
}
