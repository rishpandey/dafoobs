package com.bvp.daafobs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bvp.daafobs.beans.Subject;
import com.bvp.daafobs.providers.DaafobsServiceProvider;
import com.bvp.daafobs.services.DaafobsServices;

public class DisplaySubjectsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DaafobsServices daafobsServices = DaafobsServiceProvider.getServiceProvider();

	public DisplaySubjectsController() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession s = request.getSession(false);
		String username = s.getAttribute("username").toString();
		ArrayList<Subject> arr = new ArrayList<Subject>();
		arr = daafobsServices.displaySubject(username);
		request.setAttribute("details", arr);
		RequestDispatcher r = request.getRequestDispatcher("Result.jsp");
		r.forward(request, response);

		doGet(request, response);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession s = request.getSession(false);
		String username = s.getAttribute("username").toString();
		ArrayList<Subject> arr = new ArrayList<Subject>();
		arr = daafobsServices.displaySubject(username);
		request.setAttribute("details", arr);
		RequestDispatcher r = request.getRequestDispatcher("Result.jsp");
		r.forward(request, response);

		doGet(request, response);
	}

}
