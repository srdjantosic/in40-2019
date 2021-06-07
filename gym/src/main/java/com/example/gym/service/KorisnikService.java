package com.example.gym.service;


import org.springframework.stereotype.Service;

import com.example.gym.entity.Korisnik;
import com.example.gym.entity.dto.KorisnikDTO;
@Service
public interface KorisnikService {
	
	KorisnikDTO findKimePass(String korisnicko_ime,String lozinka);

    
}
