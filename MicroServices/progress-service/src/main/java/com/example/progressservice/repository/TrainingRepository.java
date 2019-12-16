package com.example.progressservice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.progressservice.model.Training;

@Repository
public interface TrainingRepository  extends JpaRepository<Training, String>{

	
	/*@Query(value="FROM Training t WHERE t.proposalStatus='PENDING' AND t.id=?1 ")
	public List<Training> getPendingList(Long id);*/
	
	
	@Query(value="Select * FROM training t WHERE t.tg_status='PENDING' AND t.tg_me_id=?1 ",nativeQuery=true)
	public List<Training> getPendingList(Long id);
	
	
	@Query(value="Select * FROM training t WHERE t.tg_status='APPROVED' AND t.tg_me_id=?1 ",nativeQuery=true)
	public List<Training> getApprovedList(Long id);
	

	@Query(value="FROM Training t WHERE t.status ='ACCEPTED' AND t.id=?1 ")
	public List<Training> getAcceptedList(Long id);

	@Query(value="From Training t where t.id=?1")
	public Training findAllById(Long trainingId);
	

	

}
