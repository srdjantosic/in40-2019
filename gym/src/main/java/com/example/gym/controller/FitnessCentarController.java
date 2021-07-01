package com.example.gym.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.gym.entity.FitnessCentar;
import com.example.gym.entity.dto.FitnessCentarDTO;
import com.example.gym.service.FitnessCentarService;

@RestController
@RequestMapping(value = "/api/fitnesscentar")
public class FitnessCentarController {

	private final FitnessCentarService fitnesscentarservice;
	
	 @Autowired
	    public FitnessCentarController(FitnessCentarService fitnesscentarservice) {
	        this.fitnesscentarservice = fitnesscentarservice;
	    }
	 
	 
	 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<FitnessCentarDTO> createFitnessCentar(@RequestBody FitnessCentarDTO fitnesscentarDTO) throws Exception {
	      
	        FitnessCentar fitnesscentar = new FitnessCentar(fitnesscentarDTO.getId(),fitnesscentarDTO.getNaziv(), fitnesscentarDTO.getAdresa(),
	                fitnesscentarDTO.getBroj_tel_centrale(), fitnesscentarDTO.getEmail());

	      
	        FitnessCentar newFitnesscentar = fitnesscentarservice.create(fitnesscentar);

	        
	        FitnessCentarDTO newFitnessCentarDTO = new FitnessCentarDTO(newFitnesscentar.getId(), newFitnesscentar.getNaziv(),
	                newFitnesscentar.getAdresa(), newFitnesscentar.getBroj_tel_centrale(), newFitnesscentar.getEmail());

	        
	        return new ResponseEntity<>(newFitnessCentarDTO, HttpStatus.CREATED);
	    }
	
	  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<FitnessCentarDTO>> getCentar() {
	      
	        List<FitnessCentar> fitnesscentarList = this.fitnesscentarservice.findAll();

	  
	        List<FitnessCentarDTO> fitnesscentriDTOS = new ArrayList<>();

	        for (FitnessCentar fitnesscentar : fitnesscentarList) {
	           
	            FitnessCentarDTO fitnesscentarDTO = new FitnessCentarDTO(fitnesscentar.getId(), fitnesscentar.getNaziv(),
	                    fitnesscentar.getAdresa(), fitnesscentar.getBroj_tel_centrale(),fitnesscentar.getEmail());
	            fitnesscentriDTOS.add(fitnesscentarDTO);
	        }

	        return new ResponseEntity<>(fitnesscentriDTOS, HttpStatus.OK);
	    }

	  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<FitnessCentarDTO> updateFitnessCentar(@PathVariable Long id, @RequestBody FitnessCentarDTO fitnesscentarDTO) throws Exception {
	       FitnessCentar fitnesscentar = new FitnessCentar(fitnesscentarDTO.getId(), fitnesscentarDTO.getNaziv(), fitnesscentarDTO.getAdresa(),
	                fitnesscentarDTO.getBroj_tel_centrale(), fitnesscentarDTO.getEmail());
	        
	       fitnesscentar.setId(id);

	     
	    FitnessCentar updatedEm = fitnesscentarservice.update(fitnesscentar);

	       
	       FitnessCentarDTO updatedEmDTO = new FitnessCentarDTO(updatedEm.getId(), updatedEm.getNaziv(),
	                updatedEm.getAdresa(), updatedEm.getBroj_tel_centrale(), updatedEm.getEmail());

	        
	        return new ResponseEntity<>(updatedEmDTO, HttpStatus.OK);
	    }
	 

	 @DeleteMapping(value = "/{id}")
	    public ResponseEntity<Void> deleteCentar(@PathVariable Long id) {
	       
	        this.fitnesscentarservice.delete(id);

	       
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	
}
