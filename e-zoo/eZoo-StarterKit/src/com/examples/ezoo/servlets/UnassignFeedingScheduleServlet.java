package com.examples.ezoo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.ezoo.dao.DAOUtilities;
import com.examples.ezoo.dao.FeedingScheduleDAO;

@WebServlet("/unassignFeedingSchedule")
public class UnassignFeedingScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Long animalID = Long.parseLong(request.getParameter("animalID"));
		
		FeedingScheduleDAO dao = DAOUtilities.getFeedingScheduleDao();
		boolean unassignedFeedingSchedule =
				dao.removeFeedingScheduleForAnimal(animalID);
		if (unassignedFeedingSchedule) {
			request.getSession().setAttribute("message", "Animal unassigned Schedule");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect("animalCare");
		} else {
			request.getSession()
				   .setAttribute("message", "Failed to remove schedule");
			request.getSession().setAttribute("messageClass", "alert-danger");
			
			response.sendRedirect("feedingSchedules");
		}

	}
}
