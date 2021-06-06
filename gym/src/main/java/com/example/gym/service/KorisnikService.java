package com.example.gym.service;


import org.springframework.stereotype.Service;

import com.example.gym.entity.Korisnik;
@Service
public interface KorisnikService {
	
	Korisnik findKimePass(String korisnicko_ime,String lozinka);

    
}
