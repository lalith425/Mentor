package com.cognizant.trainingservice.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	/*@Autowired
	TechnologyRepository technologyRepository;
	@Autowired
	MentorRepository mentorRepository;
	@Autowired
	MentorSkillsRepository mentorSkillsRepository;
	*/
	/*public void addSkills(MentorSkills mentorSkills,String mentorName,String skillName) throws UserAlreadyExistsException {
		LOGGER.info("Start of signupMentor");
		System.err.println("signed Mentor" + signedMentor);
		//Mentor mentorCheck = mentorRepository.findByUserID(signedMentor.getUserID());
		Technology skills=technologyRepository.findBySkillName(skillName);
		Mentor mentor=mentorRepository.findByUserID(mentorName);
		mentorSkills.setMentorId(mentor);
		mentorSkills.setSkillId(skills);
		Set<MentorSkills> list=mentor.getMentorSkillsList();
		System.err.println("***"+list);
		list.add(mentorSkills);
		System.err.println("***"+list);
		mentor.setMentorSkillList(list);
		 mentorRepository.save(mentor);
		 mentorSkillsRepository.save(mentorSkills);

		}*/
		

}
