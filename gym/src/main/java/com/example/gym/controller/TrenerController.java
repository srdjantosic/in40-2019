package com.example.gym.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
		                trenerDTO.getPrezime(), trenerDTO.getKontakt(), trenerDTO.getEmail(), trenerDTO.getDatum_rodjenja(), trenerDTO.isAktivan());

	      
	        Trener newTrener = trenerservice.create(trener);

	        
	       TrenerDTO newTrenerDTO = new TrenerDTO(newTrener.getkorisnicko_ime(), newTrener.getLozinka(),newTrener.isAktivan(),
	        		newTrener.getPrezime(),newTrener.getKontakt(), newTrener.getEmail(), newTrener.getDatum_rodjenja(),newTrener.getIme());
	        
	        return new ResponseEntity<>(newTrenerDTO, HttpStatus.CREATED);
	    }

}
