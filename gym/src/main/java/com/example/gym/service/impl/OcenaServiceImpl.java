package com.example.gym.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.entity.Ocena;

import com.example.gym.repository.OcenaRepository;
import com.example.gym.service.OcenaService;

@Service
public class OcenaServiceImpl implements OcenaService{

	
	private final OcenaRepository ocenarepository;
	
	
	@Autowired
	public OcenaServiceImpl(OcenaRepository ocenarepository) {
		super();
		this.ocenarepository = ocenarepository;
	}
	@Override
	public Ocena findOne(Long id) {
		Ocena ocena=this.ocenarepository.getOne(id);
		return ocena;
	}
	@Override
	public List<Ocena> findAll() {
		List<Ocena> ocena=this.ocenarepository.findAll();
		return ocena;
	}
	@Override
	public Ocena create(Ocena ocena) throws Exception {
		 if (ocena.getId() != null) {
	            throw new Exception("ID must be null!");
	        }
	        Ocena newOcena = this.ocenarepository.save(ocena);
	        return newOcena;
	}
	@Override
	public Ocena update(Ocena ocena) throws Exception {
		Ocena ocenaToUpdate = this.ocenarepository.getOne(ocena.getId());
        if (ocenaToUpdate == null) {
            throw new Exception("Sala doesn't exist!");
        }
        ocenaToUpdate.setVrednost(ocena.getVrednost());
  
      
     
        Ocena savedEm = this.ocenarepository.save(ocenaToUpdate);
        return savedEm;
	}
	@Override
	public void delete(Long id) {
	this.ocenarepository.deleteById(id);
	}

}
