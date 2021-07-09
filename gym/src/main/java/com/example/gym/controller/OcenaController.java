package com.example.gym.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.example.gym.entity.Clan;
import com.example.gym.entity.Ocena;
import com.example.gym.entity.Termin;
import com.example.gym.entity.Trening;
import com.example.gym.entity.dto.OcenaDTO;
import com.example.gym.service.ClanService;
import com.example.gym.service.OcenaService;
import com.example.gym.service.TreningService;

@RestController
@RequestMapping(value = "/api/ocena")
public class OcenaController {

	private final OcenaService ocenaservice;
	private final TreningService treningService;
	private final ClanService clanService;

	public OcenaController(OcenaService ocenaservice, TreningService treningService, ClanService clanService) {
		
		this.ocenaservice = ocenaservice;
		this.treningService = treningService;
		this.clanService = clanService;
	}
	
	 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<OcenaDTO> createOcena (@RequestBody OcenaDTO ocenaDTO) throws Exception {
	      
	       Ocena ocena = new Ocena(ocenaDTO.getId(),ocenaDTO.getVrednost());
	        

	      
	        Ocena newOcena = ocenaservice.create(ocena);

	        
	        OcenaDTO newOcenaDTO = new OcenaDTO(newOcena.getId(), newOcena.getVrednost());
	              

	        
	        return new ResponseEntity<>(newOcenaDTO, HttpStatus.CREATED);
	    }
	
	 @GetMapping(value = "/oceniTrening/{id}/{korisnickoIme}/{o}",produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<HttpStatus> oceniTrening(@PathVariable Long id, @PathVariable String korisnickoIme, @PathVariable int o) {
	   
	 	Trening trening = treningService.nadjiTrening(id);
	 	
	 	Clan c =clanService.findOne(korisnickoIme);
	 	if(c == null) {
	 		 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	 	}
	 	
	 	Ocena ocena = new Ocena();
	 	ocena.setClan(c);
	 	ocena.setVrednost(o);
	 	Ocena ocenaUpisana = null;
		try {
			ocenaUpisana = ocenaservice.create(ocena);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 	
	 	trening.getOcene().add(ocenaUpisana);
	 	
	 	try {
	 		treningService.update(trening);
	 	} catch (Exception e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}

	     return new ResponseEntity<>(HttpStatus.OK);
	 }
	 
	  
	 

	
	
}

	

