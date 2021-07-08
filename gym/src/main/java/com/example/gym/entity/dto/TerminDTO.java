package com.example.gym.entity.dto;


import java.util.Date;

public class TerminDTO {

	private Long id;
	private Date datum;
	private FitnessCentarDTO fitnesscentar;
	private SalaDTO sala;
	private TreningDTO trening;
	
	
	
	
	public TreningDTO getTrening() {
		return trening;
	}


	public void setTrening(TreningDTO trening) {
		this.trening = trening;
	}


	public SalaDTO getSala() {
		return sala;
	}


	public void setSala(SalaDTO sala) {
		this.sala = sala;
	}


	public void setFitnessCentar(FitnessCentarDTO fitnesscentar) {
		this.fitnesscentar = fitnesscentar;
	}

	
	public FitnessCentarDTO getFitnesscentar() {
		return fitnesscentar;
	}




	public TerminDTO() {
		
	}
	
	public TerminDTO(Long id, Date datum) {
		super();
		this.id = id;
		this.datum = datum;
	}

	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date date) {
		this.datum = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
