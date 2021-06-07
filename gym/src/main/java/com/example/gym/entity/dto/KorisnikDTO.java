package com.example.gym.entity.dto;

public class KorisnikDTO {

	private String korisnicko_ime;
	private String lozinka;
	private String role;
	
	
	public KorisnikDTO() {
		// TODO Auto-generated constructor stub
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


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public KorisnikDTO(String korisnicko_ime, String lozinka,String role) {
		super();
		this.korisnicko_ime = korisnicko_ime;
		this.lozinka = lozinka;
		this.role = role;
	}
	
	

}
