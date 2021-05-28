package com.example.gym.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.gym.entity.Clan;
import com.example.gym.entity.dto.ClanDTO;
import com.example.gym.service.ClanService;


	@RestController
	@RequestMapping(value = "/api/clan")
	public class ClanController {

		private final ClanService clanservice;
		
		 @Autowired
		    public ClanController(ClanService clanservice) {
		        this.clanservice = clanservice;
		    }
		 
		 
		 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
		            produces = MediaType.APPLICATION_JSON_VALUE)
		    public ResponseEntity<ClanDTO> createClan(@RequestBody ClanDTO clanDTO) throws Exception {
		      
		        Clan clan = new Clan(clanDTO.getKorisnicko_ime(), clanDTO.getLozinka(), clanDTO.getIme(),
		                clanDTO.getPrezime(), clanDTO.getKontakt(), clanDTO.getEmail(), clanDTO.getDatum_rodjenja(), clanDTO.isAktivan());

		      
		      Clan newClan = clanservice.create(clan);

		        
		        ClanDTO newClanDTO = new ClanDTO (newClan.getkorisnicko_ime(), newClan.getLozinka(),newClan.getIme(),
		        		newClan.getPrezime(),newClan.getKontakt(), newClan.getEmail(), newClan.getDatum_rodjenja(),newClan.isAktivan());

		        
		        return new ResponseEntity<>(newClanDTO, HttpStatus.CREATED);
		    }

}

