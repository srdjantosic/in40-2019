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

import com.example.gym.entity.Sala;
import com.example.gym.entity.dto.FitnessCentarDTO;
import com.example.gym.entity.dto.SalaDTO;
import com.example.gym.service.SalaService;

@RestController
@RequestMapping(value = "/api/sala")
public class SalaController {
	private final SalaService salaservice;

    @Autowired
    public SalaController(SalaService salaservice) {
        this.salaservice = salaservice;
    }

    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaDTO>> getSale() {
       
        List<Sala> salaList = this.salaservice.findAll();

        List<SalaDTO> salaDTOS = new ArrayList<>();

        for (Sala sala : salaList) {
        	FitnessCentarDTO fitness = new FitnessCentarDTO();
        	fitness.setId(sala.getFitnesscentar().getId());
        	fitness.setNaziv(sala.getFitnesscentar().getNaziv());  
            SalaDTO salaDTO = new SalaDTO(sala.getId(), sala.getKapacitet(), sala.getOznaka());
            salaDTO.setFitnessCentar(fitness);
            salaDTOS.add(salaDTO);
        }

  
        return new ResponseEntity<>(salaDTOS, HttpStatus.OK);
    }

   
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> createSala(@RequestBody SalaDTO salaDTO) throws Exception {
      
    	Sala sala = new Sala(salaDTO.getId() ,salaDTO.getKapacitet(), salaDTO.getOznaka());

        
        Sala newSala = salaservice.create(sala);

        
        SalaDTO newSalaDTO = new SalaDTO(newSala.getId(), newSala.getKapacitet(),
                newSala.getOznaka());

       
        return new ResponseEntity<>(newSalaDTO, HttpStatus.CREATED);
    }

    
       
     
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> updateSala(@PathVariable Long id, @RequestBody SalaDTO salaDTO) throws Exception {
        
        
      Sala sala = new Sala(salaDTO.getId(), salaDTO.getKapacitet(), salaDTO.getOznaka());
        
        sala.setId(id);

        
        Sala updatedEm = salaservice.update(sala);

        SalaDTO updatedEmDTO = new SalaDTO(updatedEm.getId(), updatedEm.getKapacitet(),
                updatedEm.getOznaka());

        return new ResponseEntity<>(updatedEmDTO, HttpStatus.OK);
    }

    
     
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteSala(@PathVariable Long id) {
        
        this.salaservice.delete(id);

       
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



	
}
