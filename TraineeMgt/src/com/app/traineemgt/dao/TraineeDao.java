package com.app.traineemgt.dao;

import java.util.List;

import com.app.traineemgt.model.service.Trainee;

public interface TraineeDao {
	public List<Trainee> allTrainees();
	public Trainee addTrainee(Trainee trainee);

}
