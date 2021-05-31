package com.example.gym.controller;
import com.example.gym.entity.Termin;
import com.example.gym.entity.Trening;
import com.example.gym.entity.dto.TerminDTO;
import com.example.gym.entity.dto.TreningDTO;
import com.example.gym.service.TerminService;
import com.example.gym.service.TreningService;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/treninzi")
public class TreningController {

 private final TreningService treningservice;
 private final TerminService terminService;

 @Autowired
public TreningController(TreningService treningservice, TerminService terminService) {
	super();
	this.treningservice = treningservice;
	this.terminService = terminService;
}
 
 @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
 public ResponseEntity<List<TreningDTO>> getTreninzi() {

     List<Trening> treningList = this.treningservice.findAll();

   
     List<TreningDTO> treningDTOS = new ArrayList<>();

     for (Trening trening : treningList) {
  
         TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
                 trening.getOpis(), trening.getTip_treninga(), trening.getTrajanje(), trening.getCena());
         treningDTOS.add(treningDTO);
     }


     return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
 }
 
 @GetMapping(value = "/sortCena", produces = MediaType.APPLICATION_JSON_VALUE)
 public ResponseEntity<List<TreningDTO>> getTreninziSortiraniCena() {

	
    

     List<Trening> treningList = this.treningservice.sortTreningByCena();

     
     List<TreningDTO> treningDTOS = new ArrayList<>();

     for (Trening trening : treningList) {
  
         TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
                 trening.getOpis(), trening.getTip_treninga(), trening.getTrajanje(), trening.getCena());
         treningDTOS.add(treningDTO);
     }


     return new ResponseEntity<>(treningDTOS, HttpStatus.OK);

 
 }
 
 @GetMapping(value = "/sortTermin", produces = MediaType.APPLICATION_JSON_VALUE)
 public ResponseEntity<List<TreningDTO>> getSortiraniTreniziTermin() {
	 List<TreningDTO> treningDTOS = new ArrayList<>();
     List<Trening> treningList =this.treningservice.findAll();
     for(Trening trening : treningList) {
    	 List<Termin> termini = this.terminService.findSorted(trening.getId());
    	 List<TerminDTO> terminidto = new ArrayList<TerminDTO>(); 
    	 for(Termin termin: termini) {
    		 System.out.println(termin.getId());
    		 TerminDTO tdto = new TerminDTO();
    		 tdto.setDatum(termin.getDatum());
    		 terminidto.add(tdto);
    	 }
    	 TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
                 trening.getOpis(), trening.getTip_treninga(), trening.getTrajanje(), trening.getCena());
    	 treningDTO.setTermini((ArrayList<TerminDTO>) terminidto);
         treningDTOS.add(treningDTO);
     }

     return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
     
 }
 
}
