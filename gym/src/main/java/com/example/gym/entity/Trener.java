package com.example.gym.entity;

import java.util.Set;
import javax.persistence.*;

@Entity
public class Trener extends Korisnik {
	
	
	@OneToMany(mappedBy = "trener", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<Trening> treninzi;
	@ManyToOne(fetch = FetchType.EAGER)
	public FitnessCentar fitnesscentar;
	
	@OneToMany(mappedBy = "trener", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Termin> termin;
	
	
	public Trener() {
		
	}


	public Set<Termin> getTermin() {
		return termin;
	}

	public void setTermin(Set<Termin> termin) {
		this.termin = termin;
	}

	public Trener(String korisnicko_ime, String lozinka, String ime, String prezime, String kontakt, String email,
			String datum_rodjenja, boolean aktivan) {
		super(korisnicko_ime, lozinka, ime, prezime, kontakt, email, datum_rodjenja, aktivan);
		// TODO Auto-generated constructor stub
	}
	


	}

