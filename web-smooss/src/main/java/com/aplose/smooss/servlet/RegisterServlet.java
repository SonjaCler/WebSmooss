package com.aplose.smooss.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.aplose.smooss.exception.EmailException;
import com.aplose.smooss.model.User;
import com.aplose.smooss.services.UserService;

/**
 * Servlet implementation class ExempleServlet
 */
@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		
		
		String lastName 	= request.getParameter("lastName");
		String firstName	= request.getParameter("firstName");
		String email 		= request.getParameter("email");
		String nickName 	= request.getParameter("nickName");
		String password 	= request.getParameter("password");
		
		
		User u = new User(email, password, firstName, lastName, nickName, null);
		String message;
		
		try {
			UserService.getInstance().create(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		message = "Votre compte à bien été créé !";
		response.sendRedirect("index.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		
	}

}
