package com.cognizant.searchservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.searchservice.model.MentorSkills;
import com.cognizant.searchservice.model.Technology;
import com.cognizant.searchservice.repository.MentorSkillsRepository;
import com.cognizant.searchservice.repository.TechnologyRepository;

@Service
public class SearchService {

	@Autowired
	MentorSkillsRepository mentorSkillsRepository;
	
	@Autowired
	TechnologyRepository technologyRepository;
	
	public List<MentorSkills> search(String skillName) {
		Technology tech = technologyRepository.findBySkillName(skillName);
		long id= tech.getId();
		return mentorSkillsRepository.getBySkillID(id);
		
	}
	
	
}
