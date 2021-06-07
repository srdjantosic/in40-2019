package com.example.gym.repository;

import com.example.gym.entity.Trener;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface TrenerRepository extends JpaRepository<Trener, String>{
	
	@Query("Select t from Trener t where t.korisnicko_ime=?1 and t.lozinka=?2")
	Trener findByKorisnicko_imeAndLozinka(String korisnicko_ime, String lozinka);
	@Query("SELECT t FROM Trener t WHERE t.aktivan = false")
	List<Trener> findFalse();
}
