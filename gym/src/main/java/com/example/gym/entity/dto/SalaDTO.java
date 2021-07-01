package com.example.gym.entity.dto;

public class SalaDTO {

	private Long id;
	private int kapacitet;
	private int oznaka;
	private FitnessCentarDTO fitnessCentar;
	public FitnessCentarDTO getFitnessCentar() {
		return fitnessCentar;
	}

	public void setFitnessCentar(FitnessCentarDTO fitnessCentar) {
		this.fitnessCentar = fitnessCentar;
	}

	public SalaDTO() {

	}
	
	public SalaDTO(Long id, int kapacitet, int oznaka) {
		super();
		this.kapacitet = kapacitet;
		this.oznaka = oznaka;
		this.id=id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getKapacitet() {
		return kapacitet;
	}
	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}
	public int getOznaka() {
		return oznaka;
	}
	public void setOznaka(int oznaka) {
		this.oznaka = oznaka;
	}
}
