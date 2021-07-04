package com.example.gym.entity.dto;

public class OcenaDTO {

	public int vrednost;
	public Long id;
	public OcenaDTO() {
		// TODO Auto-generated constructor stub
	}
	public int getVrednost() {
		return vrednost;
	}
	public void setVrednost(int vrednost) {
		this.vrednost = vrednost;
		
	}
	public OcenaDTO(int vrednost) {
		super();
		this.vrednost = vrednost;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public OcenaDTO(Long id, int vrednost) {
		super();
		this.vrednost = vrednost;
		this.id = id;
	}

}
