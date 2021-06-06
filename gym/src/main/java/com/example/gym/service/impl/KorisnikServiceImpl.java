package com.example.gym.service.impl;
import com.example.gym.entity.Korisnik;
import com.example.gym.repository.ClanRepository;
import com.example.gym.service.KorisnikService;
import com.example.gym.repository.TrenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class KorisnikServiceImpl implements KorisnikService{

	ClanRepository clanrepository;
	TrenerRepository trenerrepository;
	
	
	@Autowired
	public KorisnikServiceImpl(ClanRepository clanrepository, TrenerRepository trenerrepository) {
		super();
		this.clanrepository = clanrepository;
		this.trenerrepository = trenerrepository;
	}

	
	@Override
	public Korisnik findKimePass(String korisnicko_ime, String lozinka) {
		Korisnik korisnik = clanrepository.findByKorisnicko_imeAndLozinka(korisnicko_ime, lozinka);
		
		if(korisnik == null) {
			korisnik = trenerrepository.findByKorisnicko_imeAndLozinka(korisnicko_ime, lozinka);
			if(korisnik == null) {
				return null;
			}
		}
		return korisnik;
	}

	



}
