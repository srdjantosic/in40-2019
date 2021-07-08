package com.example.gym.repository;


import com.example.gym.entity.Trening;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface TreningRepository extends JpaRepository<Trening, Long>{
	
	
	
	List<Trening> findByOrderByCenaAsc ();
	
	@Query("Select t from Trening t join fetch t.termini")
	List<Trening> findTreningSort ();
	
	@Query("Select t from Trening t where t.id=?1")
	Trening nadjiTrening(Long id);
	
	@Query("Select t from Trening t where t.id=?1")
	Trening findTreningClan(Long id);
	
	
	
	List<Trening> findByNaziv(String naziv);
	
	List<Trening> findByOpis(String opis);
	
	//List<Trening> findByTip_treninga(String tip_treninga);
	
	List<Trening> findByTrajanje(int trajanje);
	
	List<Trening> findByCena(Double cena);
	
	@Query("Select t from Trening t where t.naziv=?1")
	Trening nadjiNazi(String naziv);
	
}
