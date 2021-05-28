package com.example.gym.entity;
import java.util.Set;

import javax.persistence.*;

@Entity
public class FitnessCentar{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String naziv;
	@Column
	private String adresa;
	@Column
	private String broj_tel_centrale;
	@Column
	private String email;
		
	@OneToMany(mappedBy = "fitnesscentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Sala> sale;
	
	@OneToMany(mappedBy = "fitnesscentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Trener> treneri;
	
	@OneToMany(mappedBy = "fitnesscentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Clan> clanovi;
	
	@OneToMany(mappedBy = "fitnesscentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Termin> termini;
	public FitnessCentar() {
	}
	

	public FitnessCentar(Long id, String naziv, String adresa, String broj_tel_centrale, String email) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.broj_tel_centrale = broj_tel_centrale;
		this.email = email;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Set<Sala> getSale() {
		return sale;
	}

	public void setSale(Set<Sala> sale) {
		this.sale = sale;
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


	public Long getId() {
		return id;
	}
	
		
}
