package com.cognizant.trainingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.trainingservice.exception.BookingAlreadyExistsException;
import com.cognizant.trainingservice.model.Training;
import com.cognizant.trainingservice.service.TrainingService;

@RestController
@RequestMapping("/book")
public class TrainingController {
	
	@Autowired
	TrainingService trainingService;
	
	@PostMapping("/{mentorName}/{traineeName}/{techName}")
	public void setProposalStatus(@PathVariable("mentorName") String mentorName,@PathVariable("traineeName") String traineeName,@PathVariable("techName") String techName) throws BookingAlreadyExistsException {
		System.out.println(" "+mentorName+" "+traineeName+" "+techName);
		trainingService.setProposalStatus(mentorName,traineeName,techName);
	}
	
	
	@GetMapping("/pending/{mentorName}")
	public List<Training> getPendingList(@PathVariable("mentorName") String mentorName) {
		return trainingService.getPendingList(mentorName);
	}

	
	@GetMapping("/accept/{mentorName}")
	public List<Training> getAcceptList(@PathVariable("mentorName") String mentorName) {
		
		
		return trainingService.getApprovedList(mentorName);
	}

	
	
	@PutMapping("/accepttrainee/{trainingId}")
	public void getAcceptedList(@PathVariable("trainingId") String trainingId) {
		Long id=new Long(trainingId);
		 trainingService.AcceptedList(id);
	}
	
	
	
	
	@DeleteMapping("/rejecttrainee/{traineeId}")
	public void declineRequest(@PathVariable("traineeId") String trainingId) {
		Long id=new Long(trainingId);
		 trainingService.declineRequest(id);
	}

}
