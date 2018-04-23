package com.aplose.smooss.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aplose.smooss.model.User;

import com.aplose.smooss.services.UserService;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet(urlPatterns =  "/ProfileController")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email"); 
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String nickName = request.getParameter("nickName");
		String picture = request.getParameter("picture");
		
		User u = (User)request.getSession().getAttribute("user");
		if (u != null){
			u.setEmail(email);
			u.setPassword(password);
			u.setFirstName(firstName);
			u.setLastName(lastName);
			u.setNickName(nickName);
			u.setPicture(picture);
			getServletContext().getRequestDispatcher("/WEB-INF/managementProfil.jsp").forward(request, response);
			
		} else {
		
			String message = "Le profil ne correspond pas";
			response.sendRedirect("index.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = (User)request.getSession().getAttribute("user");
		User newU = u;
		if (u != newU) {
			UserService.getInstance().update(u);
			return;
		} 
		
//		response.setContentType("text/html");
//		User u = UserService.getInstance().findByEmailAndPassword("email", "password");
		
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		String firstName = request.getParameter("firstName");
//		String lastName = request.getParameter("lastName");
//		String nickName = request.getParameter("nickName");
//		String picture = request.getParameter("picture");
//		
//		User u = UserService.getInstance().read(email,password,firstName,lastName,nickName,picture);
//		if (u != null){
//			
//			HttpSession session = request.getSession();
//			session.getAttribute("email");
//			session.getAttribute("password");
//			session.getAttribute("firstName");
//			session.getAttribute("lastName");
//			session.getAttribute("nickName");
//			session.getAttribute("picture");
//			getServletContext().getRequestDispatcher("/WEB-INF/managementProfil.jsp").forward(request, response);
//			
//		} else {
//		
//			String message = "Le profil ne correspond pas";
//			response.sendRedirect("index.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
//		
//		}

		
		
		
		
//		User u = UserService.getInstance().find(request.getParameter("login, firstName"));
//		User u = UserService.getInstance().read();
//		long id = u.getId();
//		if(id > 0) {
//			User u = UserService.getInstance().find(request.getPart(id));
//		}
		
//		doGet(request, response);
	}

}
