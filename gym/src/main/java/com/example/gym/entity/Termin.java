package com.example.gym.entity;


import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Termin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column 
	private Long id;
	
		@Column 
		private Date  datum;
	   

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

	    @OneToMany(fetch = FetchType.EAGER)
		private Set<Ocena> ocena;
	   
	    public Date getDatum() {
			return datum;
		}


		public void setDatum(Date datum) {
			this.datum = datum;
		}


		public Termin() {

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


		public Sala getSala() {
			return sala;
		}


		public void setSala(Sala sala) {
			this.sala = sala;
		}


		public Trening getTrening() {
			return trening;
		}


		public void setTrening(Trening trening) {
			this.trening = trening;
		}


		public Clan getClan() {
			return clan;
		}


		public void setClan(Clan clan) {
			this.clan = clan;
		}


		public Trener getTrener() {
			return trener;
		}


		public void setTrener(Trener trener) {
			this.trener = trener;
		}


		public Set<Ocena> getOcena() {
			return ocena;
		}


		public void setOcena(Set<Ocena> ocena) {
			this.ocena = ocena;
		}


		public Termin(Long id, Date datum) {
			super();
			this.id = id;
			this.datum = datum;
		}


	

	
}
