package com.rakesh.vss.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.rakesh.vss.entities.Citizen;


@Repository
public interface CitizenRepository extends JpaRepository<Citizen,Long>{
	public Citizen findByCitizenName(String citizenName);
}
