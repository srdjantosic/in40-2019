package com.example.gym.controller;
import com.example.gym.entity.Termin;
import com.example.gym.entity.Trening;
import com.example.gym.entity.dto.FitnessCentarDTO;
import com.example.gym.entity.dto.TerminDTO;
import com.example.gym.entity.dto.TreningDTO;
import com.example.gym.service.TerminService;
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
    	 	List<Termin> termini  = terminService.findSorted(trening.getId());
    	 	for(Termin t: termini) {
    	 		Termin saFitnessCentrom = terminService.findFitnessCentarTermin(t.getId());
    	 		FitnessCentarDTO fitness = new FitnessCentarDTO();
    	 		fitness.setNaziv(saFitnessCentrom.getFitnesscentar().getNaziv());
    	 		TerminDTO terminDTO = new TerminDTO();
    	 		terminDTO.setId(t.getId());
    	 		terminDTO.setDatum(t.getDatum());
    	 		 TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
    	                 trening.getOpis(), trening.getTip_treninga(), trening.getTrajanje(), trening.getCena());
    	 		 treningDTO.setTermin(terminDTO);
    	 		 treningDTO.setFitness(fitness);
    	         treningDTOS.add(treningDTO);
    	 	}
    	
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
    		 tdto.setId(termin.getId());
    		 terminidto.add(tdto);
    	 }
    	 
    	 
    	 TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
                 trening.getOpis(), trening.getTip_treninga(), trening.getTrajanje(), trening.getCena());
    	 treningDTO.setTermini((ArrayList<TerminDTO>) terminidto);
         treningDTOS.add(treningDTO);
         
         
     }

     return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
     
 }
 
 @GetMapping(value = "/naziv/{naziv}", produces = MediaType.APPLICATION_JSON_VALUE)
 public ResponseEntity<List<TreningDTO>> 	getTrening(@PathVariable("naziv") String naziv) {
     // Pozivanjem metode servisa dobavljamo zaposlenog po ID-ju
     List<Trening> treninzi = this.treningservice.findNaziv(naziv);

     List<TreningDTO> treninziDTO = new ArrayList<TreningDTO>();
     for(Trening t : treninzi) {
    	 TreningDTO treningDTO = new TreningDTO();
         treningDTO.setId(t.getId());
         treningDTO.setNaziv(t.getNaziv());
         treningDTO.setOpis(t.getOpis());
         treningDTO.setCena(t.getCena());
         treningDTO.setTip_treninga(t.getTip_treninga());
         treningDTO.setTrajanje(t.getTrajanje());
        		 treninziDTO.add(treningDTO);
     }
    

    
     return new ResponseEntity<>(treninziDTO, HttpStatus.OK);
 
}
 @GetMapping(value = "/opis/{opis}", produces = MediaType.APPLICATION_JSON_VALUE)
 public ResponseEntity<List<TreningDTO>> getTreningPoOpisu(@PathVariable("opis") String opis) {
     
     List<Trening> treninzi = this.treningservice.findOpis(opis);

     List<TreningDTO> treninziDTO = new ArrayList<TreningDTO>();
     for(Trening t : treninzi) {
    	 TreningDTO treningDTO = new TreningDTO();
         treningDTO.setId(t.getId());
         treningDTO.setNaziv(t.getNaziv());
         treningDTO.setOpis(t.getOpis());
         treningDTO.setCena(t.getCena());
         treningDTO.setTip_treninga(t.getTip_treninga());
         treningDTO.setTrajanje(t.getTrajanje());
        		 treninziDTO.add(treningDTO);
     }
    

    
     return new ResponseEntity<>(treninziDTO, HttpStatus.OK);
 
}
 @GetMapping(value = "/cena/{cena}", produces = MediaType.APPLICATION_JSON_VALUE)
 public ResponseEntity<List<TreningDTO>> getTreningPoCeni(@PathVariable("cena") Double cena) {
     
     List<Trening> treninzi = this.treningservice.findCena(cena);

     List<TreningDTO> treninziDTO = new ArrayList<TreningDTO>();
     for(Trening t : treninzi) {
    	 TreningDTO treningDTO = new TreningDTO();
         treningDTO.setId(t.getId());
         treningDTO.setNaziv(t.getNaziv());
         treningDTO.setOpis(t.getOpis());
         treningDTO.setCena(t.getCena());
         treningDTO.setTip_treninga(t.getTip_treninga());
         treningDTO.setTrajanje(t.getTrajanje());
        		 treninziDTO.add(treningDTO);
     }
    

    
     return new ResponseEntity<>(treninziDTO, HttpStatus.OK);
 
}
 @GetMapping(value = "/trajanje/{trajanje}", produces = MediaType.APPLICATION_JSON_VALUE)
 public ResponseEntity<List<TreningDTO>> getTreningPoTrajanju(@PathVariable("trajanje") int trajanje) {
     
     List<Trening> treninzi = this.treningservice.findTrajanje(trajanje);

     List<TreningDTO> treninziDTO = new ArrayList<TreningDTO>();
     for(Trening t : treninzi) {
    	 TreningDTO treningDTO = new TreningDTO();
         treningDTO.setId(t.getId());
         treningDTO.setNaziv(t.getNaziv());
         treningDTO.setOpis(t.getOpis());
         treningDTO.setCena(t.getCena());
         treningDTO.setTip_treninga(t.getTip_treninga());
         treningDTO.setTrajanje(t.getTrajanje());
        		 treninziDTO.add(treningDTO);
     }
    

    
     return new ResponseEntity<>(treninziDTO, HttpStatus.OK);
 
}
 
 @GetMapping(value = "/pretraga/{parametar}", produces = MediaType.APPLICATION_JSON_VALUE)
 public ResponseEntity<List<TreningDTO>> pretragaTreninga(@PathVariable("parametar") String parametar) {
	 
	 List<Trening> treninzi = this.treningservice.findNaziv(parametar);
	 
	 if(treninzi.size() == 0) {
		 treninzi = this.treningservice.findOpis(parametar);
		 if(treninzi.size() == 0) {
			 
			 treninzi = this.treningservice.findCena(Double.parseDouble(parametar));
			 if(treninzi.size() == 0) {
				 treninzi = this.treningservice.findTrajanje(Integer.parseInt(parametar));
				 if( treninzi.size() == 0) {
					 return new  ResponseEntity<>( HttpStatus.NOT_FOUND);
				 }
			 }
		 }
	 }
	 

     List<TreningDTO> treninziDTO = new ArrayList<TreningDTO>();
     for(Trening t : treninzi) {
    	 TreningDTO treningDTO = new TreningDTO();
         treningDTO.setId(t.getId());
         treningDTO.setNaziv(t.getNaziv());
         treningDTO.setOpis(t.getOpis());
         treningDTO.setCena(t.getCena());
         treningDTO.setTip_treninga(t.getTip_treninga());
         treningDTO.setTrajanje(t.getTrajanje());
        		 treninziDTO.add(treningDTO);
     }
    

    
     return new ResponseEntity<>(treninziDTO, HttpStatus.OK);
 
}
}
