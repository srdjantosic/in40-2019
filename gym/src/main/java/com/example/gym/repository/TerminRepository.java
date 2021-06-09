package com.example.gym.repository;
import com.example.gym.entity.Termin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface TerminRepository extends JpaRepository<Termin, Long> {
	
	@Query("Select t from Termin t join fetch t.trening  where t.trening.id =?1 order by t.datum desc")
	List<Termin> findSorted(Long id);
	
	@Query("Select t from Termin t join fetch t.fitnesscentar  where t.id =?1")
	Termin findTerminFitnessCentar(Long id);

	
}
