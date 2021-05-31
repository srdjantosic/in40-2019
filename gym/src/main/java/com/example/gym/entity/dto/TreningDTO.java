package com.example.gym.entity.dto;

import java.util.ArrayList;

public class TreningDTO {
	
	private Long id;

	private String naziv;
	
	private String opis;
	
	private String tip_treninga;

	private int trajanje;
	
	
	private double cena;
	
	private ArrayList<TerminDTO> termini;
	
	

	public TreningDTO() {
		// TODO Auto-generated constructor stub
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



	public double getCena() {
		return cena;
	}



	public void setCena(double cena) {
		this.cena = cena;
	}



	public TreningDTO(Long id, String naziv, String opis, String tip_treninga, int trajanje, double cena) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.tip_treninga = tip_treninga;
		this.trajanje = trajanje;
		this.cena = cena;
	}



	public ArrayList<TerminDTO> getTermini() {
		return termini;
	}



	public void setTermini(ArrayList<TerminDTO> termini) {
		this.termini = termini;
	}
	

}
