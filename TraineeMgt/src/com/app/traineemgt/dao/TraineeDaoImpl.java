package com.app.traineemgt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.traineemgt.model.exceptions.DataAccessException;
import com.app.traineemgt.model.service.Trainee;

public class TraineeDaoImpl implements TraineeDao {
	private Connection connection;
	
	public TraineeDaoImpl() {
		this.connection=ConnectionFactory.getConnection();
	}

	@Override
	public List<Trainee> allTrainees() {
		List<Trainee> trainees = new ArrayList<>();
		Trainee trainee=null;
		
		try {
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery("select * from trainees");
			while(rs.next()) {
				trainee=new Trainee(rs.getInt("traineeId"), rs.getString("traineeName"), rs.getString("branch"), rs.getDouble("percentage"));
				trainees.add(trainee);
;			}
			
		}catch(SQLException ex) {
			throw new DataAccessException(ex.getMessage());
		}
		
		return trainees;
	}
	

	@Override
	public Trainee addTrainee(Trainee trainee) {
		try {
			PreparedStatement pstmt = connection.prepareStatement("insert into trainees(traineeName, branch, percentage) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, trainee.getTraineeName());
			pstmt.setString(2, trainee.getBranch());
			pstmt.setDouble(3, trainee.getPercentage());
			
			pstmt.executeUpdate();
			
			ResultSet rs=pstmt.getGeneratedKeys();
			if(rs.next()) {
				trainee.setTraineeId(rs.getInt(1));
			}
		}catch(SQLException ex) {
			throw new DataAccessException(ex.getCause().toString());
		}
		
		return trainee;
		
	}
	
	

}
