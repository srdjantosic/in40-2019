package com.example.gym.service.impl;
import com.example.gym.entity.Termin;
import com.example.gym.repository.TerminRepository;
import com.example.gym.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TerminServiceImpl implements TerminService{

	private final TerminRepository terminrepository;
	

	@Autowired
	public TerminServiceImpl(TerminRepository terminrepository) {
		super();
		this.terminrepository = terminrepository;
	}
	@Override
	public Termin findOne(Long id) {
		Termin termin = this.terminrepository.getOne(id);
	        return termin;
	}
	@Override
	public List<Termin> findAll() {
		 List<Termin> termini = this.terminrepository.findAll();
	        return termini;
		
	}
	@Override
	public Termin create(Termin termin) throws Exception {
		if (termin.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Termin newTermin = this.terminrepository.save(termin);
        return newTermin;
		
	}
	@Override
	public Termin update(Termin termin) throws Exception {
		 Termin terminToUpdate = this.terminrepository.getOne(termin.getId());
	        if (terminToUpdate == null) {
	            throw new Exception("Termin ne postoji");
	        }

	       terminToUpdate.setDatum(termin.getDatum());
	       Termin savedEm = this.terminrepository.save(terminToUpdate);
	        return savedEm;
	}
	@Override
	public void delete(Long id) {
		this.terminrepository.deleteById(id);
		
	}
	@Override
	public List<Termin> findSorted(Long id) {
		List<Termin> list = this.terminrepository.findSorted(id);
		if(list == null) {
			return null;
		}
		return list;
	}
	@Override
	public Termin findFitnessCentarTermin(Long id) {
		Termin termin = this.terminrepository.findTerminFitnessCentar(id);
		if( termin == null) {
			return null;
		}
		return termin;
	}
	@Override
	public Termin findSalaTermin(Long id) {
		Termin termin = this.terminrepository.nadjiTerminSaTreningom(id);
		if( termin == null) {
			return null;
		}
		return termin;
	}
	
	

}
