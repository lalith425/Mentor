package com.cognizant.technologyservice;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.technologyservice.model.Technology;
import com.cognizant.technologyservice.service.TechnologyService;

public class User {

	 @Mock
	    TechnologyService technologyService;
	    
	    @Before
	    public void init() {
	                    MockitoAnnotations.initMocks(this);
	    }
	    
	    @Test
	    public void getTechnologies() {
	    
	                    Technology tech=new Technology();
	                    tech.setDuration("123");
	                    tech.setId((long) 1);
	                    tech.setPrerequisites("java");
	                    tech.setSkillName("spring");
	                    tech.setTableOfContents("few syntax on java");
	                    
	                    
	                    
	                    List<Technology> technology = new ArrayList<>();
	                    technology.add(tech);
	                    when(technologyService.getTechnologies()).thenReturn(technology);
	                    Long ids=new Long("1");
	                    
	                    List<Technology> testTech=technologyService.getTechnologies();
	                    assertEquals(1, testTech.size());
	                    for(Technology techs : testTech) {
	                                    assertEquals(ids, techs.getId());
	                    }
	                    
	                    verify(technologyService).getTechnologies();
	                    
	    }

}
