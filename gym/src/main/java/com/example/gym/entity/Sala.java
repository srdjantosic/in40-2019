package com.example.gym.entity;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Sala {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column 
	private Long id;

	@Column
	private int kapacitet;
	
	@Column
	private int oznaka;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private FitnessCentar fitnesscentar;
	   
	@OneToMany(mappedBy = "sala", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Termin> termin;
	
	public Sala() {
		
	}

	public Sala(Long id, int kapacitet, int oznaka) {
		super();
		this.id = id;
		this.kapacitet = kapacitet;
		this.oznaka = oznaka;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FitnessCentar getFitnesscentar() {
		return fitnesscentar;
	}

	public void setFitnesscentar(FitnessCentar fitnesscentar) {
		this.fitnesscentar = fitnesscentar;
	}

	
}
