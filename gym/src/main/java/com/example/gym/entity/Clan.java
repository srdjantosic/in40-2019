package com.example.gym.entity;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Clan extends Korisnik {
	public ArrayList<Double> ocene;
	
	@ManyToMany(mappedBy = "clan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<Trening> odradjeni;
	
	@ManyToMany(mappedBy = "clan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<Trening> prijavljeni;
	
	@ManyToOne(fetch = FetchType.EAGER)
	public FitnessCentar fitnesscentar;
	
	@OneToMany(mappedBy = "clan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Termin> termin;
	public Clan() {
		
	}
	public ArrayList<Double> getOcene() {
		return ocene;
	}
	public void setOcene(ArrayList<Double> ocene) {
		this.ocene = ocene;
	}

	

}
