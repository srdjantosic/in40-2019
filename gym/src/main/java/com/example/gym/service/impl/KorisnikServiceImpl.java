package com.example.gym.service.impl;
import com.example.gym.entity.Korisnik;
import com.example.gym.entity.dto.KorisnikDTO;
import com.example.gym.repository.AdministratorRepository;
import com.example.gym.repository.ClanRepository;
import com.example.gym.service.KorisnikService;
import com.example.gym.repository.TrenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class KorisnikServiceImpl implements KorisnikService{

	ClanRepository clanrepository;
	TrenerRepository trenerrepository;
	AdministratorRepository administratorrepository;
	
	@Autowired
	public KorisnikServiceImpl(ClanRepository clanrepository, TrenerRepository trenerrepository,AdministratorRepository administratorrepository) {
		super();
		this.clanrepository = clanrepository;
		this.trenerrepository = trenerrepository;
		this.administratorrepository=administratorrepository;
	}

	
	@Override
	public KorisnikDTO findKimePass(String korisnicko_ime, String lozinka) {
		Korisnik korisnik = clanrepository.findByKorisnicko_imeAndLozinka(korisnicko_ime, lozinka);
		KorisnikDTO korisnikDTO = new KorisnikDTO();
		if(korisnik == null) {
			korisnik = trenerrepository.findByKorisnicko_imeAndLozinka(korisnicko_ime, lozinka);
			if(korisnik == null) {
				korisnik=administratorrepository.findByKorisnicko_imeAndLozinka(korisnicko_ime, lozinka);
				if(korisnik==null) {
					return null;
				}else {
					korisnikDTO.setKorisnicko_ime(korisnik.getkorisnicko_ime());
					korisnikDTO.setLozinka(korisnik.getLozinka());
					korisnikDTO.setRole("ADMIN");
				}
			}else {
				korisnikDTO.setKorisnicko_ime(korisnik.getkorisnicko_ime());
				korisnikDTO.setLozinka(korisnik.getLozinka());
				korisnikDTO.setRole("TRENER");
			}
			
		}else {
			korisnikDTO.setKorisnicko_ime(korisnik.getkorisnicko_ime());
			korisnikDTO.setLozinka(korisnik.getLozinka());
			korisnikDTO.setRole("CLAN");
		}
		return korisnikDTO;
	}

	



}
