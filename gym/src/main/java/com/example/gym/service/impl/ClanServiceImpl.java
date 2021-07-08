package com.example.gym.service.impl;
import com.example.gym.entity.Clan;
import com.example.gym.repository.ClanRepository;
import com.example.gym.service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClanServiceImpl implements ClanService {

	private final ClanRepository clanrepository;

	@Autowired
	public ClanServiceImpl(ClanRepository clanrepository) {
		super();
		this.clanrepository = clanrepository;
	}

	@Override
	public Clan findOne(String korisnicko_ime) {
		Clan clan  = this.clanrepository.getOne(korisnicko_ime);
        return clan;

	}

	@Override
	public List<Clan> findAll() {
		List<Clan> clan = this.clanrepository.findAll();
        return clan;
	}

	@Override
	public Clan create(Clan clan) throws Exception {
		
        Clan newclan = this.clanrepository.save(clan);
        return newclan;
	}

	@Override
	public Clan update(Clan clan) throws Exception {
		Clan clanToUpdate = this.clanrepository.getOne(clan.getkorisnicko_ime());
        if (clanToUpdate == null) {
            throw new Exception("Employee doesn't exist!");
        }

      
        clanToUpdate.setLozinka(clan.getLozinka());
        clanToUpdate.setIme(clan.getIme());
        clanToUpdate.setPrezime(clan.getPrezime());
        clanToUpdate.setKontakt(clan.getKontakt());
        clanToUpdate.setEmail(clan.getEmail());
        clanToUpdate.setDatum_rodjenja(clan.getDatum_rodjenja());
        clanToUpdate.setAktivan(clan.isAktivan());
        
        Clan savedEm = this.clanrepository.save(clanToUpdate);
        return savedEm;
		
	}

	@Override
	public void delete(String korisnicko_ime) {
		 this.clanrepository.deleteById(korisnicko_ime);
		
	}

	@Override
	public Clan nadjiPrijavljeneClanoveTrening(String korisnicko_ime) {
		return this.clanrepository.nadjiPrijavljene(korisnicko_ime);
		
	}

	@Override
	public Clan nadjiOdradjeneClanoveTrening(String korisnicko_ime) {
		return this.clanrepository.nadjiOdradjene(korisnicko_ime);
	}
	
	


}
