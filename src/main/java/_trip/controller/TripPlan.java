package _trip.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _trip_tool.DateDays;



@WebServlet("/TripPlan")
public class TripPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String startDate=request.getParameter("StartDate");
		String endDate = request.getParameter("EndDate");
		System.out.println(startDate);
		System.out.println(endDate); 
		
		int days=DateDays.daysOfTwo(startDate, endDate);
		
		
		System.out.println(days);
		request.setAttribute("range", days);
		RequestDispatcher rd = request.getRequestDispatcher("tripPlan.jsp");
		rd.forward(request, response);
			
		
		
	}

}
