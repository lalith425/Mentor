package com.cognizant.authenticationservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.authenticationservice.controller.UserController;
import com.cognizant.authenticationservice.model.Mentor;
import com.cognizant.authenticationservice.model.MentorSkills;

@SpringBootTest
public class AuthenticationServiceApplicationTests {

	@Mock
	UserController userController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getSkills() {

		Mentor mentor1 = new Mentor();
		mentor1.setConfirmPassword("pwd");
		mentor1.setContactNo("122");
		mentor1.setEmail("aa");
		mentor1.setFirstName("aa");
		mentor1.setId((long) 1);
		mentor1.setLastName("aa");

		mentor1.setPassword("pwd");
		mentor1.setUserID("123");
		mentor1.setYearsOfExperience((float) 1);

		List<Mentor> mentor = new ArrayList<>();
		mentor.add(mentor1);
		when(userController.getMentors()).thenReturn(mentor);

		// test
		List<Mentor> testMentor = userController.getMentors();
		assertEquals(1, testMentor.size());
		for (Mentor mentors : testMentor) {
			assertEquals("aa", mentors.getFirstName());
		}

		verify(userController).getMentors();

	}

	@Test
	public void getMentorSkills() {

		MentorSkills mentorSkills1 = new MentorSkills();
		mentorSkills1.setExperience((long) 1);
		mentorSkills1.setFacilities("all");
		mentorSkills1.setId((long) 1);
		mentorSkills1.setRating((long) 4);
		mentorSkills1.setId((long) 2);
		mentorSkills1.setTrainings("few");

		List<MentorSkills> mentorskill = new ArrayList<>();
		mentorskill.add(mentorSkills1);
		when(userController.getMentorSkills()).thenReturn(mentorskill);

		// test
		Long testid = new Long("2");
		List<MentorSkills> testMentorSkill = userController.getMentorSkills();
		assertEquals(1, testMentorSkill.size());
		for (MentorSkills mentorskills : testMentorSkill) {
			assertEquals(testid, mentorskills.getId());
		}

		verify(userController).getMentorSkills();

	}



}