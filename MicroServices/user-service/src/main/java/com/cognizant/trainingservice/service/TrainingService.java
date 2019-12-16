package com.cognizant.trainingservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.trainingservice.exception.BookingAlreadyExistsException;
import com.cognizant.trainingservice.model.Training;
import com.cognizant.trainingservice.repository.MentorRepository;
import com.cognizant.trainingservice.repository.TechnologyRepository;
import com.cognizant.trainingservice.repository.TraineeRepository;
import com.cognizant.trainingservice.repository.TrainingRepository;

@Service
public class TrainingService {

	@Autowired
	TrainingRepository trainingRepository;
	
	@Autowired
	MentorRepository mentorRepository;
	
	@Autowired
	TraineeRepository traineeRepository;
	
	@Autowired
	TechnologyRepository TechnologyRepository;
	
	@Transactional
	public void setProposalStatus(String mentorName, String traineeName, String techName) throws BookingAlreadyExistsException{
		Training training = new Training();
		Long mentorId=mentorRepository.findByUserID(mentorName).getId();
		Long traineeId=traineeRepository.findByUserID(traineeName).getId();
		Long techId=TechnologyRepository.findBySkillName(techName).getId();
		Training check = trainingRepository.isAlreadyBooked(mentorId,traineeId,techId);
		if(check == null) {
		
		training.setMentorId(mentorRepository.findByUserID(mentorName));
		training.setTraineeId(traineeRepository.findByUserID(traineeName));
		training.setTechId(TechnologyRepository.findBySkillName(techName));
		training.setStatus("PENDING");
		trainingRepository.save(training);
	}
		else {
			throw new BookingAlreadyExistsException();
		}
	}
	@Transactional
	public List<Training> getPendingList(String mentorName) {
		Long id = mentorRepository.findByUserID(mentorName).getId();
		return trainingRepository.getPendingList(id);
	}
	
	
	@Transactional
	public List<Training> getApprovedList(String mentorName) {
		Long id = mentorRepository.findByUserID(mentorName).getId();
		return trainingRepository.getApprovedList(id);
	}
	
	
	@Transactional
	public void AcceptedList(Long trainingId) {
		Training training=this.trainingRepository.findAllById(trainingId);
		training.setStatus("APPROVED");
		 this.trainingRepository.save(training);
	}

	@Transactional
	public void declineRequest(Long trainingId) {
		Training training=this.trainingRepository.findAllById(trainingId);
		
		 this.trainingRepository.delete(training);
		
	}

	
	
	
	
}
