package com.example.gym.service;

import com.example.gym.entity.Ocena;

import java.util.List;

public interface OcenaService {
	Ocena findOne(Long id);

    List<Ocena> findAll();

    Ocena create(Ocena ocena) throws Exception;

    Ocena update(Ocena ocena) throws Exception;

    void delete(Long id);
	
}
