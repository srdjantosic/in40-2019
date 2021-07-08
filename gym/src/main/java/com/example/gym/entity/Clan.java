package com.example.gym.entity;


import java.util.Set;

import javax.persistence.*;

@Entity
public class Clan extends Korisnik {
	
	
	@ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<Trening> odradjeni;
	
	@OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

	public Set<Trening> getOdradjeni() {
		return odradjeni;
	}

	public void setOdradjeni(Set<Trening> odradjeni) {
		this.odradjeni = odradjeni;
	}

	public Set<Trening> getPrijavljeni() {
		return prijavljeni;
	}

	public void setPrijavljeni(Set<Trening> prijavljeni) {
		this.prijavljeni = prijavljeni;
	}

	public FitnessCentar getFitnesscentar() {
		return fitnesscentar;
	}

	public void setFitnesscentar(FitnessCentar fitnesscentar) {
		this.fitnesscentar = fitnesscentar;
	}

	public Set<Termin> getTermin() {
		return termin;
	}

	public void setTermin(Set<Termin> termin) {
		this.termin = termin;
	}
	
	

	

}
