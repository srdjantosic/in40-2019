package com.example.gym.service;
import com.example.gym.entity.Clan;

import java.util.List;

public interface ClanService {
	
	 Clan findOne(String korisnicko_ime);

	    List<Clan> findAll();

	    Clan create(Clan clan) throws Exception;

	    Clan update(Clan clan) throws Exception;

	    Clan nadjiPrijavljeneClanoveTrening(String korisnicko_ime);
	    
	    Clan nadjiOdradjeneClanoveTrening(String korisnicko_ime);
	    
	    void delete(String  korisnicko_ime);
}
