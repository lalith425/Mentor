package com.cognizant.trainingservice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.trainingservice.model.Training;

@Repository
public interface TrainingRepository  extends JpaRepository<Training, String>{

	
	/*@Query(value="FROM Training t WHERE t.proposalStatus='PENDING' AND t.id=?1 ")
	public List<Training> getPendingList(Long id);*/
	
	
	@Query(value="Select * FROM training t WHERE t.tg_status='PENDING' AND t.tg_me_id=?1 ",nativeQuery=true)
	public List<Training> getPendingList(Long id);
	
	
	@Query(value="Select * FROM training t WHERE t.tg_status='APPROVED'  OR t.tg_status='COMPLETED' AND t.tg_me_id=?1 ",nativeQuery=true)
	public List<Training> getApprovedList(Long id);
	

	@Query(value="FROM Training t WHERE t.status ='ACCEPTED' AND t.id=?1 ")
	public List<Training> getAcceptedList(Long id);

	@Query(value="From Training t where t.id=?1")
	public Training findAllById(Long trainingId);
	

	@Query(value="select * from training t where t.tg_me_id=?1 and t.tg_tr_id=?2 and t.tg_te_id=?3",nativeQuery=true)
	public Training isAlreadyBooked(Long mentorId, Long traineeId, Long techId);
	

}
