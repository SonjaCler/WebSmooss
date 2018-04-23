package com.aplose.smooss.servlet;

import java.io.IOException;
import java.time.Instant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aplose.smooss.model.Event;
import com.aplose.smooss.model.User;
import com.aplose.smooss.services.EventService;

/**
 * Servlet implementation class EventController
 */
@WebServlet(urlPatterns = "/EventController")
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User admin = (User)request.getSession().getAttribute("user");
		String name = request.getParameter("titleEvent");
		String description = request.getParameter("descriptionEvent");
		String location = request.getParameter("locationEvent");
		Instant start = formatDateAndTime(request.getParameter("startDateEvent"), request.getParameter("startTimeEvent"));
		Instant end = formatDateAndTime(request.getParameter("endDateEvent"), request.getParameter("endTimeEvent"));
		//String picture = PictureService.getInstance().getPictureBase64(request.getParameter("picture"));
		String picture = null;
		
		Event evt = new Event(admin, name, description, location, start, end, picture);
		EventService.getInstance().create(evt);
		
		request.setAttribute("event", evt);
		
		getServletContext().getRequestDispatcher("/WEB-INF/event.jsp").forward(request, response);
	}
	
	private Instant formatDateAndTime(String date, String time) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(date.replace("/",":"));
		sb.append("T");
		sb.append(time);
		sb.append(":00Z");
		
		return Instant.parse(sb.toString());
	}

}
