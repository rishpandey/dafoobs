package com.bvp.daafobs.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.bvp.daafobs.beans.Student;



public class LoginFilter implements Filter {

   
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		if (request.getParameter("username").equals("") || request.getParameter("password").equals("")) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<html>");
			out.println("<body>");
			out.println("<center>");
			out.println("<font color='red', size='8'>");
			out.println("All fields are mandatory");
			out.println("</font>");
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");

			RequestDispatcher rd = request.getRequestDispatcher("/StudentLogin.html");
			rd.include(request, response);
		}

		else {
			Student student = new Student(request.getParameter("username"), request.getParameter("password"));
			request.setAttribute("student", student);

			chain.doFilter(request, response);

		}		

	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	System.out.println("hello in init login");	// TODO Auto-generated method stub
	}

}
