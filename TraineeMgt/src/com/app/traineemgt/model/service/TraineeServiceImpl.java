package com.app.traineemgt.model.service;

import java.util.List;

import com.app.traineemgt.dao.TraineeDao;
import com.app.traineemgt.dao.TraineeDaoImpl;

public class TraineeServiceImpl implements TraineeService {

	private TraineeDao traineeDao;
	
	public TraineeServiceImpl() {
		this.traineeDao=new TraineeDaoImpl();
	}
	@Override
	public List<Trainee> allTrainees() {
		return traineeDao.allTrainees();
	}

	@Override
	public Trainee addTrainee(Trainee trainee) {
		return traineeDao.addTrainee(trainee);
	}
	
}
