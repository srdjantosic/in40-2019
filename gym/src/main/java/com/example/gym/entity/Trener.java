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
			String datum_rodjenja, boolean aktivan, boolean obrisan) {
		super(korisnicko_ime, lozinka, ime, prezime, kontakt, email, datum_rodjenja, aktivan, obrisan);
		
	}


	@Override
	public String getkorisnicko_ime() {
		// TODO Auto-generated method stub
		return super.getkorisnicko_ime();
	}


	@Override
	public void setkorisnicko_ime(String korisnicko_ime) {
		// TODO Auto-generated method stub
		super.setkorisnicko_ime(korisnicko_ime);
	}


	@Override
	public String getLozinka() {
		// TODO Auto-generated method stub
		return super.getLozinka();
	}


	@Override
	public void setLozinka(String lozinka) {
		// TODO Auto-generated method stub
		super.setLozinka(lozinka);
	}


	@Override
	public String getIme() {
		// TODO Auto-generated method stub
		return super.getIme();
	}


	@Override
	public void setIme(String ime) {
		// TODO Auto-generated method stub
		super.setIme(ime);
	}


	@Override
	public String getPrezime() {
		// TODO Auto-generated method stub
		return super.getPrezime();
	}


	@Override
	public void setPrezime(String prezime) {
		// TODO Auto-generated method stub
		super.setPrezime(prezime);
	}


	@Override
	public String getKontakt() {
		// TODO Auto-generated method stub
		return super.getKontakt();
	}


	@Override
	public void setKontakt(String kontakt) {
		// TODO Auto-generated method stub
		super.setKontakt(kontakt);
	}


	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}


	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}


	@Override
	public String getDatum_rodjenja() {
		
		return super.getDatum_rodjenja();
	}


	@Override
	public void setDatum_rodjenja(String datum_rodjenja) {
		// TODO Auto-generated method stub
		super.setDatum_rodjenja(datum_rodjenja);
	}


	@Override
	public boolean isAktivan() {
		// TODO Auto-generated method stub
		return super.isAktivan();
	}


	@Override
	public void setAktivan(boolean aktivan) {
		// TODO Auto-generated method stub
		super.setAktivan(aktivan);
	}


	public Set<Trening> getTreninzi() {
		return treninzi;
	}


	public void setTreninzi(Set<Trening> treninzi) {
		this.treninzi = treninzi;
	}


	public FitnessCentar getFitnesscentar() {
		return fitnesscentar;
	}


	public void setFitnesscentar(FitnessCentar fitnesscentar) {
		this.fitnesscentar = fitnesscentar;
	}
	


	}

