package com.example.gym.service;
import com.example.gym.entity.Trening;


import java.util.List;
public interface TreningService {


	Trening findOne(Long id);

	    List<Trening> findAll();

	    Trening create(Trening trening) throws Exception;

	    Trening update(Trening trening) throws Exception;

	    void delete(Long id);
	    
	    List<Trening> sortTreningByCena();
}

