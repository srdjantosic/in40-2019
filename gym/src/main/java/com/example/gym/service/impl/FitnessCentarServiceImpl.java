package com.example.gym.service.impl;

import com.example.gym.entity.FitnessCentar;
import com.example.gym.repository.FitnessCentarRepository;
import com.example.gym.service.FitnessCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class FitnessCentarServiceImpl implements FitnessCentarService {

	private final FitnessCentarRepository fitnesscentarrepository;

	@Autowired
	public FitnessCentarServiceImpl(FitnessCentarRepository fitnesscentarrepository) {
		super();
		this.fitnesscentarrepository = fitnesscentarrepository;
	}

	@Override
	public FitnessCentar findOne(Long id) {
		FitnessCentar fitnesscentar = this.fitnesscentarrepository.getOne(id);
	        return fitnesscentar;
	
	}

	@Override
	public List<FitnessCentar> findAll() {
		List<FitnessCentar> fitnesscentar = this.fitnesscentarrepository.findAll();
        return fitnesscentar;
	}

	@Override
	public FitnessCentar create(FitnessCentar fitnesscentar) throws Exception {
		  if (fitnesscentar.getId() != null) {
	            throw new Exception("ID must be null!");
	        }
	        FitnessCentar newFitnesscentar = this.fitnesscentarrepository.save(fitnesscentar);
	        return newFitnesscentar;
	}

	@Override
	public FitnessCentar update(FitnessCentar fitnesscentar) throws Exception {
		FitnessCentar fitnesscentarToUpdate = this.fitnesscentarrepository.getOne(fitnesscentar.getId());
	        if (fitnesscentarToUpdate == null) {
	            throw new Exception("Fitness centar doesn't exist!");
	        }
	        fitnesscentarToUpdate.setNaziv(fitnesscentar.getNaziv());
	        fitnesscentarToUpdate.setEmail(fitnesscentar.getEmail());
	        fitnesscentarToUpdate.setAdresa(fitnesscentar.getAdresa());
	        fitnesscentarToUpdate.setBroj_tel_centrale(fitnesscentar.getBroj_tel_centrale());

	     
	        FitnessCentar savedEm = this.fitnesscentarrepository.save(fitnesscentarToUpdate);
	        return savedEm;
	}

	@Override
	public void delete(Long id) {
		 this.fitnesscentarrepository.deleteById(id);
		
	}
	
	
	

}
