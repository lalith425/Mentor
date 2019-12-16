package com.example.progressservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "training")
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tg_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="tg_me_id")
	private Mentor mentorId;
	
	@ManyToOne
	@JoinColumn(name="tg_tr_id")
	private Trainee traineeId;
	
	@ManyToOne
	@JoinColumn(name="tg_te_id")
	private Technology techId;
	
	@Column(name="tg_status")
	private String status;
	
	@Column(name="tg_progress")
	private String progress;
	
	@Column(name="tg_topicscovered")
	private String topicscovered;

	@Column(name="tg_review")
	private String review;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Mentor getMentorId() {
		return mentorId;
	}

	public void setMentorId(Mentor mentorId) {
		this.mentorId = mentorId;
	}

	public Trainee getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Trainee traineeId) {
		this.traineeId = traineeId;
	}

	public Technology getTechId() {
		return techId;
	}

	public void setTechId(Technology techId) {
		this.techId = techId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getTopicscovered() {
		return topicscovered;
	}

	public void setTopicscovered(String topicscovered) {
		this.topicscovered = topicscovered;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Training [id=" + id + ", mentorId=" + mentorId + ", traineeId=" + traineeId + ", techId=" + techId
				+ ", status=" + status + ", progress=" + progress + ", topicscovered=" + topicscovered + ", review="
				+ review + "]";
	}

	public Training(Long id, Mentor mentorId, Trainee traineeId, Technology techId, String status, String progress,
			String topicscovered, String review) {
		super();
		this.id = id;
		this.mentorId = mentorId;
		this.traineeId = traineeId;
		this.techId = techId;
		this.status = status;
		this.progress = progress;
		this.topicscovered = topicscovered;
		this.review = review;
	}

	public Training() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
