package com.example.gym.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gym.entity.Korisnik;
import com.example.gym.entity.dto.KorisnikDTO;
import com.example.gym.service.KorisnikService;


@RestController
@RequestMapping(value = "/api/login")
public class LoginController {

	
	 private final KorisnikService korisnikservice;
	

	 @Autowired
	public LoginController(KorisnikService korisnikservice) {
		super();
		this.korisnikservice = korisnikservice;
		
	}
	 @GetMapping(value = "/{kime}/{lozinka}", produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<KorisnikDTO> getKorisnik(@PathVariable("kime") String korisnicko_ime, @PathVariable("lozinka") String lozinka) {
		 Korisnik korisnik = korisnikservice.findKimePass(korisnicko_ime, lozinka);
		 if(korisnik == null) {
			 return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		 }
	     KorisnikDTO k = new KorisnikDTO();
	     k.setKorisnicko_ime(korisnik.getkorisnicko_ime());
	     k.setLozinka(korisnik.getLozinka());
	     return new ResponseEntity<>(k, HttpStatus.OK);
	 }
}
