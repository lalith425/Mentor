package com.cognizant.userservice;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.trainingservice.model.Training;
import com.cognizant.trainingservice.service.TrainingService;

public class User {

	@Mock
	TrainingService trainingService;
    
	
    @Before
    public void init() {
    MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void getAllTrainingList() {
    
        Training training1 =new Training();
        training1.setId((long) 1);
//        training1.setMentorId(mentorId);
        training1.setProgress("going");
        
       
        
        
        List<Training> training = new ArrayList<>();
        training.add(training1);
        when(trainingService.getApprovedList("ram")).thenReturn(training);
        Long ids=new Long("1");
        //test
        List<Training> testtraining=trainingService.getApprovedList("ram");
        assertEquals(1, testtraining.size());
        for(Training trainings : testtraining) {
                        assertEquals(ids, trainings.getId());
        }
        
        verify(trainingService).getApprovedList("ram");
                  
}


}
