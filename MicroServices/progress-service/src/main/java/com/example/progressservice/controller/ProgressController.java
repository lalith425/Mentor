package com.example.progressservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.progressservice.model.Training;
import com.example.progressservice.service.ProgressService;

@RestController
@RequestMapping("/progress")
public class ProgressController {
	
	@Autowired
	ProgressService  progressService;	
	
	@GetMapping("/edit/{trainingId}")
	public Training getTraining(@PathVariable("trainingId") String trainingId) {
		long trainingID=new Long(trainingId);
		return progressService.getTraining(trainingID);
	}
	
	@PutMapping("/update")
	public Training getTraining(@RequestBody Training training) {
	
		return progressService.updateTraining(training);
	}
	
	
	@GetMapping("/user/{traineeName}")
	public List<Training> getForTrainee(@PathVariable("traineeName") String traineeName) {
		return progressService.getForTrainee(traineeName);
	}
}
