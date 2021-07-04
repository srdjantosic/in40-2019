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


import com.example.gym.entity.Trener;

import com.example.gym.entity.dto.TrenerDTO;
import com.example.gym.service.TrenerService;

@RestController
@RequestMapping(value = "/api/trener")
public class TrenerController {

	private final TrenerService trenerservice;
	
	 @Autowired
	    public TrenerController(TrenerService trenerservice) {
	        this.trenerservice = trenerservice;
	    }
	 
	 
	 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<TrenerDTO> createTrener(@RequestBody TrenerDTO trenerDTO) throws Exception {
	      
	       Trener trener = new Trener(trenerDTO.getKorisnicko_ime(), trenerDTO.getLozinka(), trenerDTO.getIme(),
		                trenerDTO.getPrezime(), trenerDTO.getKontakt(), trenerDTO.getEmail(), trenerDTO.getDatum_rodjenja(), trenerDTO.isAktivan(),trenerDTO.isObrisan());

	      trener.setObrisan(false);
	        Trener newTrener = trenerservice.create(trener);

	        
	       TrenerDTO newTrenerDTO = new TrenerDTO(newTrener.getkorisnicko_ime(), newTrener.getLozinka(),newTrener.isAktivan(),
	        		newTrener.getPrezime(),newTrener.getKontakt(), newTrener.getEmail(), newTrener.getDatum_rodjenja(),newTrener.getIme(), newTrener.isObrisan());
	        
	        return new ResponseEntity<>(newTrenerDTO, HttpStatus.CREATED);
	    }
	 @PostMapping(value="/aktivnost", consumes = MediaType.APPLICATION_JSON_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<TrenerDTO> createnTrener(@RequestBody TrenerDTO trenerDTO) throws Exception {
	      
	       Trener trener = new Trener(trenerDTO.getKorisnicko_ime(), trenerDTO.getLozinka(), trenerDTO.getIme(),
		                trenerDTO.getPrezime(), trenerDTO.getKontakt(), trenerDTO.getEmail(), trenerDTO.getDatum_rodjenja(), trenerDTO.isAktivan(),trenerDTO.isObrisan());

	      trener.setObrisan(false);
	      trener.setAktivan(true);
	        Trener newTrener = trenerservice.create(trener);

	        
	       TrenerDTO newTrenerDTO = new TrenerDTO(newTrener.getkorisnicko_ime(), newTrener.getLozinka(),newTrener.isAktivan(),
	        		newTrener.getPrezime(),newTrener.getKontakt(), newTrener.getEmail(), newTrener.getDatum_rodjenja(),newTrener.getIme(), newTrener.isObrisan());
	        
	        return new ResponseEntity<>(newTrenerDTO, HttpStatus.CREATED);
	    }
	 
	  @GetMapping(value = "/aktivan", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<TrenerDTO>> getNeAktivni() {
		  List<Trener> treneri = this.trenerservice.findTrenerNeAktivan();
		  List<TrenerDTO> trenerDTOS = new ArrayList<>();
	        for (Trener trener : treneri) {
	            TrenerDTO trenerDTO = new TrenerDTO(trener.getkorisnicko_ime(), trener.getLozinka(),trener.isAktivan(),
	                    trener.getIme(),trener.getPrezime(),trener.getKontakt(),trener.getEmail(),trener.getDatum_rodjenja(), trener.isObrisan());
	            trenerDTOS.add(trenerDTO);	           
	        }
	        return new ResponseEntity<>(trenerDTOS ,HttpStatus.OK);
	    }
	  
	   @PutMapping(value = "/updateTrener/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<TrenerDTO> updateTrener(@PathVariable String id, @RequestBody TrenerDTO trenerDTO) throws Exception {
	       
	        Trener updatedEm = trenerservice.update(id);
	    

	     TrenerDTO newTrener = new TrenerDTO();
	     newTrener.setAktivan(updatedEm.isAktivan());
	     newTrener.setIme(updatedEm.getIme());
	     newTrener.setPrezime(updatedEm.getPrezime());
	     newTrener.setEmail(updatedEm.getEmail());
	     newTrener.setKorisnicko_ime(updatedEm.getkorisnicko_ime());
	     newTrener.setDatum_rodjenja(updatedEm.getDatum_rodjenja());
	     newTrener.setLozinka(updatedEm.getLozinka());
	     newTrener.setKontakt(updatedEm.getKontakt());
	     
	       
	        return new ResponseEntity<>(newTrener, HttpStatus.OK);
	    }
	   @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<TrenerDTO>> getTrener() {
	      
	        List<Trener> trenerList = this.trenerservice.findAll();

	  
	        List<TrenerDTO> treneriDTOS = new ArrayList<>();

	        for (Trener trener: trenerList) {
	           if(!trener.isObrisan()) {
	        	   TrenerDTO trenerDTO = new TrenerDTO( trener.getkorisnicko_ime(),
	        			   trener.getLozinka(),trener.isAktivan(), trener.getIme(),trener.getPrezime(),trener.getKontakt(), trener.getEmail(),trener.getDatum_rodjenja(), trener.isObrisan());
	        	   treneriDTOS.add(trenerDTO);
	           }
	        }

	        return new ResponseEntity<>(treneriDTOS, HttpStatus.OK);
	    }


		 @DeleteMapping(value = "/{id}")
		    public ResponseEntity<Void> deleteCentar(@PathVariable String id) {
		       System.out.println(id);
		        this.trenerservice.delete(id);

		       
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		
}


