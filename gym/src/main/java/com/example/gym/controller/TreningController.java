package com.example.gym.controller;
import com.example.gym.entity.Trening;
import com.example.gym.entity.dto.TreningDTO;
import com.example.gym.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/treninzi")
public class TreningController {

 private final TreningService treningservice;

 @Autowired
public TreningController(TreningService treningservice) {
	super();
	this.treningservice = treningservice;
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
 
}
