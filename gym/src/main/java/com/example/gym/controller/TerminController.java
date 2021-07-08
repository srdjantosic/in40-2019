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

import com.example.gym.entity.Clan;
import com.example.gym.entity.Sala;
import com.example.gym.service.ClanService;
import com.example.gym.service.SalaService;
import com.example.gym.entity.Termin;
import com.example.gym.entity.Trening;
import com.example.gym.entity.dto.SalaDTO;
import com.example.gym.entity.dto.TerminDTO;
import com.example.gym.entity.dto.TreningDTO;
import com.example.gym.service.TerminService;
import com.example.gym.service.TreningService;

@RestController
@RequestMapping(value = "/api/termin")
public class TerminController {

	private final TerminService terminservice;
	private final TreningService treningservice;
	private final ClanService clanservice;
	private final SalaService salaservice;
	
	
	@Autowired
	public TerminController(TerminService terminservice,TreningService treningservice,ClanService clanservice, SalaService salaservice) {
		super();
		this.terminservice = terminservice;
		this.treningservice=treningservice;
		this.clanservice=clanservice;
		this.salaservice = salaservice;
	}

	 @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<TerminDTO>> getTermin() {
	      
	        List<Termin> terminList = this.terminservice.findAll();

	  
	        List<TerminDTO> terminiDTOS = new ArrayList<>();

	        for (Termin termin : terminList) {
	        	  
	        	SalaDTO sala= new SalaDTO();
	        	sala.setId(termin.getSala().getId());
	        	sala.setOznaka(termin.getSala().getOznaka());
	        	TreningDTO trening=new TreningDTO();
	        	trening.setId(termin.getTrening().getId());
	        	trening.setNaziv(termin.getTrening().getNaziv());
	        	trening.setCena(termin.getTrening().getCena());
	        	
	           TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getDatum());
	          
	           terminDTO.setSala(sala);
	           terminDTO.setTrening(trening);
	            terminiDTOS.add(terminDTO);
	        }

	        return new ResponseEntity<>(terminiDTOS, HttpStatus.OK);
	    }

	 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<TerminDTO> createFitnessCentar(@RequestBody TerminDTO terminDTO) throws Exception {
	      
		 Trening t=treningservice.nadji(terminDTO.getTrening().getNaziv());
		 
		 
	       Termin termin = new Termin(terminDTO.getId(),terminDTO.getDatum() );
	       termin.setTrening(t);
	      
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
@GetMapping(value = "/prijavitrening/{id}/{korisnickoIme}",produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<HttpStatus> prijaviTrening(@PathVariable Long id, @PathVariable String korisnickoIme) {
  
	Trening trening = treningservice.nadjiTrening(id);
	Termin t = terminservice.findSalaTermin(id);
	if(t == null) {
		 return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	if(t.getSala().getKapacitet() == 0) {
		 return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	Clan c =this.clanservice.findOne(korisnickoIme);
	
	Sala s = this.salaservice.findOne(t.getSala().getId());
	int brojMesta = s.getKapacitet()-1;
	if(brojMesta < 0) {
		s.setKapacitet(0);
	}else {
		s.setKapacitet(brojMesta);
	}
	try {
		this.salaservice.update(s);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	c.getPrijavljeni().add(trening);
	try {
		this.clanservice.update(c);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    return new ResponseEntity<>(HttpStatus.OK);
}



@GetMapping(value = "/odraditrening/{id}/{korisnickoIme}",produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<HttpStatus> odradiTrening(@PathVariable Long id, @PathVariable String korisnickoIme) {
  
	Trening trening = treningservice.nadjiTrening(id);
	Termin t = terminservice.findSalaTermin(id);
	
	if(t == null) {
		 return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	Clan c =this.clanservice.findOne(korisnickoIme);
	
	c.getOdradjeni().add(trening);
	try {
		this.clanservice.update(c);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    return new ResponseEntity<>(HttpStatus.OK);
}

}
