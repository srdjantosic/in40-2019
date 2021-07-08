package com.example.gym.entity;


import java.util.Set;

import javax.persistence.*;
@Entity
public class Trening {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column 
	private Long id;

	@Column
	private String naziv;
	
	@Column
	private String opis;
	
	
	@Column
	private String tip_treninga;
	
	@Column
	private int trajanje;
	
	@Column
	private double cena;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Trener trener;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= CascadeType.MERGE)
	private Set<Clan> clan;
	
	@OneToMany(mappedBy = "trening", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Termin> termini;
	
	
	public Trening() {
		
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
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	
	public String getTip_treninga() {
		return tip_treninga;
	}
	public void setTip_treninga(String tip_treninga) {
		this.tip_treninga = tip_treninga;
	}
	public int getTrajanje() {
		return trajanje;
	}
	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}
	
	

	public Trener getTrener() {
		return trener;
	}

	public void setTrener(Trener trener) {
		this.trener = trener;
	}

	public Set<Clan> getClan() {
		return clan;
	}

	public void setClanovi(Set<Clan> clan) {
		this.clan = clan;
	}

	public Set<Termin> getTermini() {
		return termini;
	}

	public void setTermini(Set<Termin> termini) {
		this.termini = termini;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}
	

	



	
	
	
	
}
