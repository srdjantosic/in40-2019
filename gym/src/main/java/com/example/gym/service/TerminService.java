package com.example.gym.service;
import com.example.gym.entity.Termin;

import java.util.List;
public interface TerminService {
	Termin findOne(Long id);

    List<Termin> findAll();

    Termin create(Termin termin) throws Exception;

    Termin update(Termin termin) throws Exception;

    void delete(Long id);
    
    List<Termin> findSorted(Long id);
}
