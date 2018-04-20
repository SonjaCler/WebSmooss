package com.aplose.smooss.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadPicture
 */
@WebServlet("/UploadPictureServlet")

public class UploadPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadPictureServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/managementProfil.jsp").forward(request, response);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text,html");
		PrintWriter out = response.getWriter();
		
		Collection<Part> parts = request.getParts();
		for (Iterator iterator = parts.iterator(); iterator.hasNext();) {
			Part part = (Part) iterator.next();
		}

		
		
		out.write("<h2> Total parts : " + parts.size()+ "</h2>");
		
		Part part = request.getPart("file");
		System.out.println("File name = "+ getFileName(part));
		//printPart(part,out);
		String fileName = getFileName(part);
		part.write(fileName);
		
		}

	private String getFileName(Part part) {
		String partHeader = part.getHeader("content-disposition");
		for (String cd : part.getHeader("content-disposition").split(";"))
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
			}

		return null;

	}

}
