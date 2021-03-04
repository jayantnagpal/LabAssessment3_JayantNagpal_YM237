package com.app.traineemgt.model.service;

public class Trainee {
	private int traineeId;
	private String traineeName;
	private String branch;
	private Double percentage;
	
	public Trainee() {

	}

	public Trainee(int traineeId, String traineeName, String branch, Double percentage) {
		this.traineeId = traineeId;
		this.traineeName = traineeName;
		this.branch = branch;
		this.percentage = percentage;
	}

	public Trainee(String traineeName, String branch, Double percentage) {
		this.traineeName = traineeName;
		this.branch = branch;
		this.percentage = percentage;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public int getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	
	
	
}
