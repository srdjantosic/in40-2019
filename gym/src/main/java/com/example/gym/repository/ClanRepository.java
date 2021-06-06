package com.example.gym.repository;
import com.example.gym.entity.Clan;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface ClanRepository extends JpaRepository<Clan, String> {
	
	@Query("Select c from Clan c where c.korisnicko_ime=?1 and c.lozinka=?2")
	Clan findByKorisnicko_imeAndLozinka(String korisnicko_ime, String lozinka);
}
