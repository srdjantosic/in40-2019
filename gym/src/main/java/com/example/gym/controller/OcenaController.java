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
import com.example.gym.entity.Ocena;
import com.example.gym.entity.dto.OcenaDTO;
import com.example.gym.service.OcenaService;

@RestController
@RequestMapping(value = "/api/ocena")
public class OcenaController {

	private final OcenaService ocenaservice;

	public OcenaController(OcenaService ocenaservice) {
		
		this.ocenaservice = ocenaservice;
	}
	
	 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<OcenaDTO> createOcena (@RequestBody OcenaDTO ocenaDTO) throws Exception {
	      
	       Ocena ocena = new Ocena(ocenaDTO.getId(),ocenaDTO.getVrednost());
	        

	      
	        Ocena newOcena = ocenaservice.create(ocena);

	        
	        OcenaDTO newOcenaDTO = new OcenaDTO(newOcena.getId(), newOcena.getVrednost());
	              

	        
	        return new ResponseEntity<>(newOcenaDTO, HttpStatus.CREATED);
	    }
	
	 @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<OcenaDTO>> getOcene() {
	       
	        List<Ocena> ocenaList = this.ocenaservice.findAll();

	        List<OcenaDTO> ocenaDTOS = new ArrayList<>();

	        for (Ocena ocena : ocenaList) {
	        	  
	        	
	            OcenaDTO ocenaDTO = new OcenaDTO(ocena.getId(), ocena.getVrednost());
	           
	            ocenaDTOS.add(ocenaDTO);
	        }

	  
	        return new ResponseEntity<>(ocenaDTOS, HttpStatus.OK);
	    }
	 
	  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<OcenaDTO> updateOcena(@PathVariable Long id, @RequestBody OcenaDTO ocenaDTO) throws Exception {
	      Ocena ocena = new Ocena(ocenaDTO.getId(), ocenaDTO.getVrednost());
	              
	        
	       ocena.setId(id);

	     
	  Ocena updatedEm = ocenaservice.update(ocena);

	       
	       OcenaDTO updatedEmDTO = new OcenaDTO(updatedEm.getId(), updatedEm.getVrednost());
	         

	        
	        return new ResponseEntity<>(updatedEmDTO, HttpStatus.OK);
	    }
	 

	 @DeleteMapping(value = "/{id}")
	    public ResponseEntity<Void> deleteOcena(@PathVariable Long id) {
	       
	        this.ocenaservice.delete(id);

	       
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	
}

	

