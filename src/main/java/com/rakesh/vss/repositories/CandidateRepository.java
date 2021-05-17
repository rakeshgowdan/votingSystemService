package com.rakesh.vss.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.rakesh.vss.entities.Candidate;


@Repository
public interface CandidateRepository  extends JpaRepository<Candidate,Long>  {

	public Candidate findByCandidateName(String candidateName);


}
