package com.example.progressservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.progressservice.model.Training;

public interface ProgressRepository extends JpaRepository<Training, String> {

	
	@Query("FROM Training t WHERE t.id=?1")
	public Training findAllById(long trainingId);
	
	
	@Query(value="Select * from training where tg_tr_id=?1", nativeQuery=true)
	public List<Training> findAllTraineeId(long trainee);
	
	
}
