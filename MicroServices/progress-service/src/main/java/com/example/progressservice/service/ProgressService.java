package com.example.progressservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.progressservice.model.Training;
import com.example.progressservice.repository.ProgressRepository;
import com.example.progressservice.repository.TraineeRepository;
@Service
public class ProgressService {


	@Autowired
	ProgressRepository progressRepository;
	
	
	@Autowired
	TraineeRepository traineeRepository;
	
	@Transactional
	public Training getTraining(long trainingId) {
		return this.progressRepository.findAllById(trainingId);
	}
		 
		@Transactional
		public Training updateTraining(Training training) {
			return this.progressRepository.save(training);
	}

		@Transactional
		public List<Training> getForTrainee(String trainingName) {
			long trainee=traineeRepository.findByUserID(trainingName).getId();
			return this.progressRepository.findAllTraineeId(trainee);
		}
	
}
