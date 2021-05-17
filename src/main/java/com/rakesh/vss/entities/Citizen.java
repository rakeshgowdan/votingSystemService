package com.rakesh.vss.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="citizens")
@Entity
@Data
public class Citizen {

	@Id
	@Column
	private Long id;
	
	@Column
	private String citizenName;
	
	@Column(name="hasvoted")
	private Boolean hasVoted;

	
}
