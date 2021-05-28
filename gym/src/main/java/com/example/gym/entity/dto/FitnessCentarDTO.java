package com.example.gym.entity.dto;



public class FitnessCentarDTO {

	private Long id;

	private String naziv;
	
	private String adresa;

	private String broj_tel_centrale;

	private String email;
	public FitnessCentarDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public FitnessCentarDTO(Long id, String naziv, String adresa, String broj_tel_centrale, String email) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.broj_tel_centrale = broj_tel_centrale;
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getBroj_tel_centrale() {
		return broj_tel_centrale;
	}
	public void setBroj_tel_centrale(String broj_tel_centrale) {
		this.broj_tel_centrale = broj_tel_centrale;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
