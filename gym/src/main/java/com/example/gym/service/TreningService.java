package com.example.gym.service;
import com.example.gym.entity.Trening;


import java.util.List;
public interface TreningService {


	Trening findOne(Long id);

	    List<Trening> findAll();

	    Trening create(Trening trening) throws Exception;

	    Trening update(Trening trening) throws Exception;
	    
	    Trening nadji(String naziv);

	    void delete(Long id);
	    
	    Trening nadjiTrening(Long id);
	    
	    
	    List<Trening> sortTreningByCena();

	    List<Trening> sortTrening();
	    
	    List<Trening> findNaziv(String naziv);
		List<Trening> findOpis(String opis);
		//List<Trening> findTip_treninga(String tip_treninga);
		List<Trening> findTrajanje(int trajanje);
		List<Trening> findCena(Double cena);
		
		
}

