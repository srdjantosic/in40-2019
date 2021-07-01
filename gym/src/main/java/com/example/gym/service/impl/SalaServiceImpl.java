package com.example.gym.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.entity.Sala;
import com.example.gym.service.SalaService;
import com.example.gym.repository.SalaRepository;

@Service
public class SalaServiceImpl implements SalaService {

	private final SalaRepository salarepository;

		
	
	@Autowired
	public SalaServiceImpl(SalaRepository salarepository) {
		super();
		this.salarepository = salarepository;
	}

	@Override
	public Sala findOne(Long id) {
		Sala sala = this.salarepository.getOne(id);
        return sala;
	}

	@Override
	public List<Sala> findAll() {
		List<Sala> sala = this.salarepository.findAll();
        return sala;
	}

	@Override
	public Sala create(Sala sala) throws Exception {
		 if (sala.getId() != null) {
	            throw new Exception("ID must be null!");
	        }
	        Sala newSala = this.salarepository.save(sala);
	        return newSala;
	}

	@Override
	public Sala update(Sala sala) throws Exception {
		Sala salaToUpdate = this.salarepository.getOne(sala.getId());
        if (salaToUpdate == null) {
            throw new Exception("Sala doesn't exist!");
        }
        salaToUpdate.setKapacitet(sala.getKapacitet());
        salaToUpdate.setOznaka(sala.getOznaka());
      
     
        Sala savedEm = this.salarepository.save(salaToUpdate);
        return savedEm;
	}

	@Override
	public void delete(Long id) {
	 this.salarepository.deleteById(id);
		
	}

}
