package com.example.gym.entity.dto;



public class ClanDTO {

private String korisnicko_ime;
	
	
	private String lozinka;

	private boolean aktivan;
	
	private String ime;

	
	private String prezime;


	private String kontakt;

	
	private String email;
	
	
	private String datum_rodjenja;
	private boolean obrisan;

	public ClanDTO() {
		
	}

	public String getKorisnicko_ime() {
		return korisnicko_ime;
	}

	public void setKorisnicko_ime(String korisnicko_ime) {
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


	public ClanDTO(String korisnicko_ime, String lozinka, String datum_rodjenja, String ime, String prezime, String kontakt,
			String email, boolean aktivan, boolean obrisan) {
		super();
		this.korisnicko_ime = korisnicko_ime;
		this.lozinka = lozinka;
		this.ime = ime;
		this.aktivan = aktivan;
		this.prezime = prezime;
		this.kontakt = kontakt;
		this.email = email;
		this.datum_rodjenja = datum_rodjenja;
		this.obrisan=obrisan;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

}
