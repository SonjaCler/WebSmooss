package com.aplose.smooss.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.aplose.smooss.model.User;
import com.aplose.smooss.services.PictureService;
import com.aplose.smooss.tools.StringTools;

/**
 * Servlet implementation class PictureController
 */
@WebServlet("/PictureController")
@MultipartConfig(location="/tmp", fileSizeThreshold=1024*1024, maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class PictureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PictureController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Part p = request.getPart("file");
		User author = (User)request.getSession().getAttribute("user");
		String description = request.getParameter("picture_description");
		String name = request.getParameter("picture_name");
		String fileName = StringTools.generateRandomString(12);
		p.write(fileName);
		File picture = new File("/tmp/"+fileName);
		PictureService.getInstance().createPicture(picture, name, description, author);
		picture.delete();
		
	}

}
