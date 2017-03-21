package com.bvp.daafobs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bvp.daafobs.beans.Student;
import com.bvp.daafobs.providers.DaafobsServiceProvider;
import com.bvp.daafobs.services.DaafobsServices;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	DaafobsServices daafobsServices=DaafobsServiceProvider.getServiceProvider(); 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		Student student=(Student) request.getAttribute("student");
		
		if(daafobsServices.loginStudent(student)){

			HttpSession s = request.getSession(true);
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println("in controller");
			s.setAttribute("username", username);
			s.setAttribute("password", password);
			
			getServletContext().getRequestDispatcher("/Success.jsp").forward(request, response);
		}
		
		else {
			response.setContentType("text/html");
			out.println("<html>");
			out.println("<body>");
			out.println("<center>");
			out.println("<font color='red', size='10'>");
			out.println("Invalid Username and Password!");
			out.println("</font>");
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
			getServletContext().getRequestDispatcher("/StudentLogin.html").include(request, response);

		}
		
		
	}

}
