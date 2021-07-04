package com.example.gym.entity;


import java.util.Set;

import javax.persistence.*;

@Entity
public class Clan extends Korisnik {
	
	
	@ManyToMany(mappedBy = "clan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<Trening> odradjeni;
	
	@ManyToMany(mappedBy = "clan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<Trening> prijavljeni;
	
	@ManyToOne(fetch = FetchType.EAGER)
	public FitnessCentar fitnesscentar;
	
	@OneToMany(mappedBy = "clan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Termin> termin;
	

	
	
	public Clan() {
		
	}

	public Clan(String korisnicko_ime, String lozinka, String ime, String prezime, String kontakt, String email,
			String datum_rodjenja, boolean aktivan,boolean obrisan) {
		super(korisnicko_ime, lozinka, ime, prezime, kontakt, email, datum_rodjenja, aktivan, obrisan);
		
	}
	

	

}
