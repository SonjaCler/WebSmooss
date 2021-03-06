package com.aplose.smooss.servlet;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Iterator;
import java.util.List;

import javax.json.Json;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.aplose.smooss.model.Event;
import com.aplose.smooss.model.Module.TypeModule;
import com.aplose.smooss.model.User;
import com.aplose.smooss.services.EventService;
import com.aplose.smooss.tools.ImageTools;
import com.aplose.smooss.tools.StringTools;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class EventController
 */
@WebServlet(urlPatterns = "/EventController")
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024
		* 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EventController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("idEvent");
		// response.setContentType("application/json");
		// response.setCharacterEncoding("UTF-8");
		String json = "[]";
		if (id != null) {
			Event evt = EventService.getInstance().read(Long.parseLong(id));
			request.setAttribute("event", evt);
			getServletContext().getRequestDispatcher("/WEB-INF/event.jsp").forward(request, response);
		} else {
			// Get all events for the connected user
			User user = (User) request.getSession().getAttribute("user");
			if (user != null) {
				List<Event> events = EventService.getInstance().findEventsByUser(user);
				request.setAttribute("events", events);

				// ObjectMapper mapper = new ObjectMapper();
				// json = mapper.writeValueAsString(events);
			}
		}
		// response.getWriter().write(json);
		getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String inputdelete = request.getParameter("inputDelete");
		
		if(inputdelete != null) {
			doDelete(request, response);
			response.sendRedirect("EventController");
		}

		else {

			User admin = (User) request.getSession().getAttribute("user");
			String name = request.getParameter("titleEvent");
			String description = request.getParameter("descriptionEvent");
			String location = request.getParameter("locationEvent");
			Instant start = formatDateAndTime(request.getParameter("startDateEvent"),
					request.getParameter("startTimeEvent"));
			Instant end = formatDateAndTime(request.getParameter("endDateEvent"), request.getParameter("endTimeEvent"));

			String fileName = StringTools.generateRandomString(12);
			Part p = request.getPart("pictureEvent");
			p.write(fileName);
			File picture = new File("/tmp/" + fileName);
			String pictureBase64 = ImageTools.encodeImageBase64(picture);

			Event evt = new Event(admin, name, description, location, start, end, pictureBase64);
			EventService.getInstance().create(evt);

			String[] parameters = new String[] { "PlaylistModule", "TriCountModule", "PicturesModule", "ChatModule",
					"MiniGameModule", "CarpoolingModule", "BringModule" };

			for (String parameter : parameters) {
				String checkBoxValue = request.getParameter(parameter);
				if (checkBoxValue != null) {
					switch (parameter) {
					case "PlaylistModule":
						EventService.getInstance().addModuleByEvent(evt, TypeModule.PlaylistModule);
						break;
					default:
					case "TriCountModule":
						EventService.getInstance().addModuleByEvent(evt, TypeModule.TriCountModule);
						break;
					case "PicturesModule":
						EventService.getInstance().addModuleByEvent(evt, TypeModule.PicturesModule);
						break;
					case "ChatModule":
						EventService.getInstance().addModuleByEvent(evt, TypeModule.ChatModule);
						break;
					case "MiniGameModule":
						EventService.getInstance().addModuleByEvent(evt, TypeModule.MiniGameModule);
						break;
					case "CarpoolingModule":
						EventService.getInstance().addModuleByEvent(evt, TypeModule.CarpoolingModule);
						break;
					case "BringModule":
						EventService.getInstance().addModuleByEvent(evt, TypeModule.BringModule);
						break;
					}
				}
			}

			request.setAttribute("event", evt);

			getServletContext().getRequestDispatcher("/WEB-INF/event.jsp").forward(request, response);
		}
	}

	private Instant formatDateAndTime(String date, String time) {

		StringBuilder sb = new StringBuilder();
		sb.append(date.replace("/", ":"));
		sb.append("T");
		sb.append(time);
		sb.append(":00Z");

		return Instant.parse(sb.toString());
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("idEvent");
		Event evt = EventService.getInstance().read(Long.parseLong(id));
		EventService.getInstance().modify(evt);
	//	super.doPut(request, response);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("idEvent");
		Event evt = EventService.getInstance().read(Long.parseLong(id));
		EventService.getInstance().delete(evt);
	 // super.doDelete(request, response);
	}

}
