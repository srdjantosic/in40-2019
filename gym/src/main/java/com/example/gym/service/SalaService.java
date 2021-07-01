package com.example.gym.service;
import com.example.gym.entity.Sala;

import java.util.List;




public interface SalaService {

	Sala findOne(Long id);

	    List<Sala> findAll();

	    Sala create(Sala sala) throws Exception;

	    Sala update(Sala sala) throws Exception;

	    void delete(Long id);
}
