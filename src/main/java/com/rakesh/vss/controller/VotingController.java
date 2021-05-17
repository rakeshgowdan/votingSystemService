package com.rakesh.vss.controller;

import org.jboss.logging.Logger;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rakesh.vss.entities.Candidate;
import com.rakesh.vss.entities.Citizen;

import com.rakesh.vss.repositories.CandidateRepository;

import com.rakesh.vss.repositories.CitizenRepository;

@Controller
public class VotingController {

	public final Logger logger = Logger.getLogger(VotingController.class);

	@Autowired
	CitizenRepository citizenRepo;

	@Autowired
	CandidateRepository candidateRepo;

	@RequestMapping("/")
	public String goToVote() {
		logger.info("Returning vote.html file");
		return "vote";
	}

	@RequestMapping("/doLogin")
	public String doLogin(@RequestParam String name, Model model, HttpSession session) {

		logger.info("getting citizen from database");

		Citizen citizen = citizenRepo.findByCitizenName(name);

		logger.info("putting citizen into session");
		session.setAttribute("citizen", citizen);

		if (!citizen.getHasVoted()) {
			logger.info("putting candidates into model");
			List<Candidate> candidates = candidateRepo.findAll();
			model.addAttribute("candidates", candidates);
			return "/performVoted.html";
		} else {
			return "/alreadyVoted.html";
		}

	}

	@RequestMapping("/voteFor")
	public String voteFor(@RequestParam Long id, HttpSession session) {

		Citizen citizen = (Citizen) session.getAttribute("citizen");

		if (!citizen.getHasVoted()) {

			citizen.setHasVoted(true);

			Candidate c = candidateRepo.findById((long) id).orElse(null);
			logger.info("voting for candidate " + c.getCandidateName());
			c.setNumberOfVotes(c.getNumberOfVotes() + 1);

			candidateRepo.save(c);
			citizenRepo.save(citizen);

			return "voted.html";
		}

		return "alreadyVoted.html";

	}
}
