package com.cognizant.authenticationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.authenticationservice.model.Mentor;
import com.cognizant.authenticationservice.model.MentorSkills;
import com.cognizant.authenticationservice.model.Trainee;
import com.cognizant.authenticationservice.repository.MentorRepository;
import com.cognizant.authenticationservice.repository.MentorSkillsRepository;
import com.cognizant.authenticationservice.repository.RoleRepository;
import com.cognizant.authenticationservice.repository.UserRepository;
import com.cognizant.authenticationservice.security.AppUserDetailsService;
import com.cognizant.authenticationservice.service.UserService;

@RequestMapping("/signup")
@RestController
public class UserController {

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	MentorRepository mentorRepository;
	
	@Autowired
	MentorSkillsRepository mentorSkillsRepository;
	
	@Autowired
	UserService userService;

	
	
	@PostMapping("/mentor")
	public String signUpMentor(@RequestBody Mentor mentor) throws UserAlreadyExistsException {
		return appUserDetailsService.signUpMentor(mentor);

	}
	
	@PostMapping("/trainee")
	public String signUpTrainee(@RequestBody Trainee trainee) throws UserAlreadyExistsException {
		return appUserDetailsService.signUpTrainee(trainee);

	}
	

	@PostMapping("/mentor/{name}/{skillName}")
	public void addSkills(@RequestBody MentorSkills mentorSkills,@PathVariable("name") String name,@PathVariable("skillName") String skillName) throws UserAlreadyExistsException {
		System.err.println("entereddddddddddd");
		System.err.println("mentorskills"+mentorSkills);
		
		System.err.println("name"+name);
		
		System.err.println("skillname"+skillName);
		
		
		userService.addSkill(mentorSkills,name,skillName);

	}
	
	@GetMapping("/mentors")
	public List<Mentor> getMentors() {
		return mentorRepository.findAll();
	}
	
	@GetMapping("/mentorskill")
	public List<MentorSkills> getMentorSkills() {
		return mentorSkillsRepository.findAll();
	}
}
