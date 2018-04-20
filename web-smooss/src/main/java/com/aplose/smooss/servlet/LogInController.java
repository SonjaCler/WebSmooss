package com.aplose.smooss.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aplose.smooss.model.User;
import com.aplose.smooss.services.UserService;

/**
 * Servlet implementation class LogInController
 */
@WebServlet(urlPatterns = "/LogInController")
public class LogInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email 	= request.getParameter("email");
		String password = request.getParameter("password");
		
		User u = UserService.getInstance().findByEmailAndPassword(email, password);
	
		if (u != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			session.setAttribute("email", email);
					
			getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
			
		} else {
		
			String message = "Mauvais identifiants";
			response.sendRedirect("index.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		
		}
		
	}

}
