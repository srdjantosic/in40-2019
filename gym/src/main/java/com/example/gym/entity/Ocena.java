package com.example.gym.entity;

import javax.persistence.*;

@Entity
public class Ocena {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int vrednost;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Clan clan;
	
	public Ocena() {

	}
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVrednost() {
		return vrednost;
	}

	public void setVrednost(int vrednost) {
		this.vrednost = vrednost;
	}

	public Clan getClan() {
		return clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}
	
	

	
	
	
	
	
}
