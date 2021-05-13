package com.example.gym.entity;
import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Korisnik {

	@Id
	@Column(unique=true)
	private String korisnicko_ime;
	
	@Column
	private String lozinka;


	@Column
	private String ime;

	@Column
	private String prezime;

	@Column
	private String kontakt;

	@Column(unique=true)
	private String email;
	
	@Column
	private String datum_rodjenja;


	@Column
	private boolean aktivan;

	public Korisnik() {

	}

	public String getkorisnicko_ime() {
	return korisnicko_ime;
	}


	public void setkorisnicko_ime(String korisnicko_ime) {
		this.korisnicko_ime = korisnicko_ime;
	}
	
	
	public String getLozinka() {
		return lozinka;
	}
	
	
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	
	public String getIme() {
		return ime;
	}
	
	
	public void setIme(String ime) {
	 this.ime = ime;
	}
	
	
	public String getPrezime() {
		return prezime;
	}
	
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	
	public String getKontakt() {
		return kontakt;
	}
	
	
	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getDatum_rodjenja() {
		return datum_rodjenja;
	}
	
	
	public void setDatum_rodjenja(String datum_rodjenja) {
		this.datum_rodjenja = datum_rodjenja;
	}
	
	
	public boolean isAktivan() {
		return aktivan;
	}
	
	
	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}
	

}
