package com.example.gym.entity.dto;


import java.util.Date;

public class TerminDTO {

	private Long id;
	private Date datum;
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
