package com.rakesh.vss.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="candidates")
@Entity
@Data
public class Candidate {

	@Id
	@Column
	private Long id;
	
	@Column
	private String candidateName;
	
	@Column(name="numberOfVotes")
	private Long numberOfVotes;

}
