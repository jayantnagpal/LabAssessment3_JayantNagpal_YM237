package com.app.traineemgt.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.traineemgt.model.exceptions.DataAccessException;
import com.app.traineemgt.model.service.Trainee;
import com.app.traineemgt.model.service.TraineeService;
import com.app.traineemgt.model.service.TraineeServiceImpl;

@WebServlet("/TraineeController.do")
public class TraineeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TraineeService traineeService=new TraineeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		HttpSession httpSession=request.getSession();
		
		if(action.equalsIgnoreCase("add")) {
			request.getRequestDispatcher("\\WEB-INF\\views\\AddTrainee.jsp").forward(request, response);
		}else if(action.equalsIgnoreCase("showall")) {
			List<Trainee> trainees = traineeService.allTrainees();
			request.setAttribute("trainees", trainees);
			RequestDispatcher rd = request.getRequestDispatcher("\\WEB-INF\\views\\show.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String traineeName=request.getParameter("traineeName");
		String branch=request.getParameter("branch");
		Double percentage=Double.parseDouble(request.getParameter("percentage").trim());
		
		Trainee trainee=new Trainee(traineeName, branch, percentage);
		
			try {
				trainee=traineeService.addTrainee(trainee);
			}catch(DataAccessException ex) {
				ex.printStackTrace();
			}
			
		
		
	}

}
