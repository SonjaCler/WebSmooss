package com.aplose.smooss.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.aplose.smooss.services.JPASingleton;

/**
 * Servlet implementation class LoadOnStartup
 */
@WebServlet(
		urlPatterns = "/LoadOnStartup",
		loadOnStartup = 1
)
public class LoadOnStartup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadOnStartup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		JPASingleton.getInstance().getEntityManager();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		JPASingleton.getInstance().close();
	}

}
