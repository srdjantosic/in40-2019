package com.example.gym.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Termin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column 
	private Long id;
	
	@Column 
	private Date datum;
	   

	    @ManyToOne(fetch = FetchType.EAGER)
	    private FitnessCentar fitnesscentar;

	    @ManyToOne(fetch = FetchType.EAGER)
	    private Sala sala;
	 
	    @ManyToOne(fetch = FetchType.EAGER)   
	    private Trening trening;

	    @ManyToOne(fetch = FetchType.EAGER)
	    private Clan clan;
	    @ManyToOne(fetch = FetchType.EAGER)
	    private Trener trener;

	   
	public Date getDatum() {
			return datum;
		}


		public void setDatum(Date datum) {
			this.datum = datum;
		}


	public Termin() {

	}


	@Override
	public String toString() {
		return "Termin [id=" + id + ", datum=" + datum + ", fitnesscentar=" + fitnesscentar + ", sala=" + sala
				+ ", trening=" + trening + ", clan=" + clan + ", trener=" + trener + "]";
	}

	
}
