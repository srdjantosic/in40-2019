package com.example.gym.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.gym.entity.Clan;
import com.example.gym.entity.Termin;
import com.example.gym.entity.Trening;
import com.example.gym.entity.dto.ClanDTO;
import com.example.gym.entity.dto.FitnessCentarDTO;
import com.example.gym.entity.dto.TerminDTO;
import com.example.gym.entity.dto.TreningDTO;
import com.example.gym.service.ClanService;
import com.example.gym.service.TerminService;


	@RestController
	@RequestMapping(value = "/api/clan")
	public class ClanController {

		private final ClanService clanservice;
		private final TerminService terminservice;
		
		 @Autowired
		    public ClanController(ClanService clanservice, TerminService terminservice) {
		        this.clanservice = clanservice;
		        this.terminservice = terminservice;
		    }
		 
		 
		 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
		            produces = MediaType.APPLICATION_JSON_VALUE)
		    public ResponseEntity<ClanDTO> createClan(@RequestBody ClanDTO clanDTO) throws Exception {
		      
		        Clan clan = new Clan(clanDTO.getKorisnicko_ime(), clanDTO.getLozinka(), clanDTO.getIme(),
		                clanDTO.getPrezime(), clanDTO.getKontakt(), clanDTO.getEmail(), clanDTO.getDatum_rodjenja(), clanDTO.isAktivan(), clanDTO.isObrisan());
		        clan.setObrisan(false);
	
		      Clan newClan = clanservice.create(clan);

		        
		        ClanDTO newClanDTO = new ClanDTO (newClan.getkorisnicko_ime(), newClan.getLozinka(),newClan.getIme(),
		        		newClan.getPrezime(),newClan.getKontakt(), newClan.getEmail(), newClan.getDatum_rodjenja(),newClan.isAktivan(), newClan.isObrisan());

		        
		        return new ResponseEntity<>(newClanDTO,HttpStatus.CREATED);
		    }

		 @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		    public ResponseEntity<List<TreningDTO>> getClan(@PathVariable("id") String korisnicko_ime) {
		     
		        Clan clan = this.clanservice.nadjiPrijavljeneClanoveTrening(korisnicko_ime);
		        ArrayList<TreningDTO> treninzi = new ArrayList<TreningDTO>();
		        for(Trening trening: clan.getPrijavljeni()) {
		        	List<Termin> termini  = terminservice.findSorted(trening.getId());
		    	 	for(Termin t: termini) {
		    	 		Termin saFitnessCentrom = terminservice.findFitnessCentarTermin(t.getId());
		    	 		FitnessCentarDTO fitness = new FitnessCentarDTO();
		    	 		fitness.setNaziv(saFitnessCentrom.getFitnesscentar().getNaziv());
		    	 		TerminDTO terminDTO = new TerminDTO();
		    	 		terminDTO.setId(t.getId());
		    	 		terminDTO.setDatum(t.getDatum());
		    	 		 TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
		    	                 trening.getOpis(), trening.getTip_treninga(), trening.getTrajanje(), trening.getCena());
		    	 		 treningDTO.setTermin(terminDTO);
		    	 		 treningDTO.setFitness(fitness);
		    	         treninzi.add(treningDTO);
		    	 	}
		        	
		        	
		        	
		        }
		        
		      
		        
		        return new ResponseEntity<>(treninzi,HttpStatus.OK);
		    }
		 @GetMapping(value = "/odradjeni/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		    public ResponseEntity<List<TreningDTO>> getClano(@PathVariable("id") String korisnicko_ime) {
		     
		        Clan clan = this.clanservice.nadjiOdradjeneClanoveTrening(korisnicko_ime);
		        ArrayList<TreningDTO> treninzi = new ArrayList<TreningDTO>();
		        for(Trening trening: clan.getOdradjeni()) {
		        	List<Termin> termini  = terminservice.findSorted(trening.getId());
		    	 	for(Termin t: termini) {
		    	 		Termin saFitnessCentrom = terminservice.findFitnessCentarTermin(t.getId());
		    	 		FitnessCentarDTO fitness = new FitnessCentarDTO();
		    	 		fitness.setNaziv(saFitnessCentrom.getFitnesscentar().getNaziv());
		    	 		TerminDTO terminDTO = new TerminDTO();
		    	 		terminDTO.setId(t.getId());
		    	 		terminDTO.setDatum(t.getDatum());
		    	 		 TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
		    	                 trening.getOpis(), trening.getTip_treninga(), trening.getTrajanje(), trening.getCena());
		    	 		 treningDTO.setTermin(terminDTO);
		    	 		 treningDTO.setFitness(fitness);
		    	         treninzi.add(treningDTO);
		    	 	}
		        	
		        	
		        	
		        }
		        
		      
		        
		        return new ResponseEntity<>(treninzi,HttpStatus.OK);
		    }

		 @GetMapping(value = "/prikazi/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		    public ResponseEntity<ClanDTO> getClann(@PathVariable("id") String korisnicko_ime) {
		       
		       Clan clan = this.clanservice.findOne(korisnicko_ime);

		        
		        ClanDTO clanDTO = new ClanDTO();
		        clanDTO.setKorisnicko_ime(clan.getKorisnicko_ime());
		        clanDTO.setIme(clan.getIme());
		        clanDTO.setPrezime(clan.getPrezime());
		        clanDTO.setLozinka(clan.getLozinka());
		        clanDTO.setKontakt(clan.getKontakt());
		        clanDTO.setEmail(clan.getEmail());
		        clanDTO.setDatum_rodjenja(clan.getDatum_rodjenja());

		     
		        return new ResponseEntity<>(clanDTO, HttpStatus.OK);
		    }
}

