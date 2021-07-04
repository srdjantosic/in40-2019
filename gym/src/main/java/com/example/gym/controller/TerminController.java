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


import com.example.gym.entity.Termin;
import com.example.gym.entity.dto.FitnessCentarDTO;
import com.example.gym.entity.dto.TerminDTO;
import com.example.gym.service.TerminService;

@RestController
@RequestMapping(value = "/api/termin")
public class TerminController {

	private final TerminService terminservice;
	
	@Autowired
	public TerminController(TerminService terminservice) {
		super();
		this.terminservice = terminservice;
	}

	 @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<TerminDTO>> getTermin() {
	      
	        List<Termin> terminList = this.terminservice.findAll();

	  
	        List<TerminDTO> terminiDTOS = new ArrayList<>();

	        for (Termin termin : terminList) {
	        	
	           TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getDatum());
	            terminiDTOS.add(terminDTO);
	        }

	        return new ResponseEntity<>(terminiDTOS, HttpStatus.OK);
	    }

	 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<TerminDTO> createFitnessCentar(@RequestBody TerminDTO terminDTO) throws Exception {
	      
	       Termin termin = new Termin(terminDTO.getId(),terminDTO.getDatum() );

	      
	        Termin newTermin = terminservice.create(termin);

	        
	        TerminDTO newTerminDTO = new TerminDTO(newTermin.getId(), newTermin.getDatum());
	                

	        
	        return new ResponseEntity<>(newTerminDTO, HttpStatus.CREATED);
	    }

@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<TerminDTO> updateTermin(@PathVariable Long id, @RequestBody TerminDTO terminDTO) throws Exception {
Termin termin = new Termin(terminDTO.getId(), terminDTO.getDatum());

termin.setId(id);


Termin updatedEm = terminservice.update(termin);


TerminDTO updatedEmDTO = new TerminDTO(updatedEm.getId(), updatedEm.getDatum());


return new ResponseEntity<>(updatedEmDTO, HttpStatus.OK);
}

@DeleteMapping(value = "/{id}")
public ResponseEntity<Void> deleteCentar(@PathVariable Long id) {
   System.out.println(id);
    this.terminservice.delete(id);

   
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}
