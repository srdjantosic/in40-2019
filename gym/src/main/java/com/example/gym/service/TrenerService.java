package com.example.gym.service;

import java.util.List;

import com.example.gym.entity.Trener;

public interface TrenerService {

	Trener findOne(String korisnicko_ime);

	    List<Trener> findAll();

	    Trener create(Trener trener) throws Exception;

	    Trener update(String korisnicko) throws Exception;
	    Trener nadj(String naziv);
	    void delete(String korisnicko_ime);
	    
	    List<Trener> findTrenerNeAktivan();
}
