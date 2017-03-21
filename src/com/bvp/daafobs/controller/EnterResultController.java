package com.bvp.daafobs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bvp.daafobs.beans.Result;
import com.bvp.daafobs.providers.DaafobsServiceProvider;
import com.bvp.daafobs.services.DaafobsServices;
import com.sun.corba.se.spi.resolver.Resolver;


public class EnterResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	DaafobsServices daafobsServices=DaafobsServiceProvider.getServiceProvider();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession s = request.getSession(false);
		String username = s.getAttribute("username").toString();
		String subject_a = request.getParameter("subject1")+","+request.getParameter("a_cv1")+","+request.getParameter("a_ue1")+","+request.getParameter("a_ia1")+","+request.getParameter("a_twp1")+","+request.getParameter("a_two1")+","+request.getParameter("a_result1")+","+request.getParameter("a_gp1");
		String subject_b = request.getParameter("subject2")+","+request.getParameter("a_cv2")+","+request.getParameter("a_ue2")+","+request.getParameter("a_ia2")+","+request.getParameter("a_twp2")+","+request.getParameter("a_two2")+","+request.getParameter("a_result2")+","+request.getParameter("a_gp2");
		String subject_c = request.getParameter("subject3")+","+request.getParameter("a_cv3")+","+request.getParameter("a_ue3")+","+request.getParameter("a_ia3")+","+request.getParameter("a_twp3")+","+request.getParameter("a_two3")+","+request.getParameter("a_result3")+","+request.getParameter("a_gp3");
		String subject_d = request.getParameter("subject4")+","+request.getParameter("a_cv4")+","+request.getParameter("a_ue4")+","+request.getParameter("a_ia4")+","+request.getParameter("a_twp4")+","+request.getParameter("a_two4")+","+request.getParameter("a_result4")+","+request.getParameter("a_gp4");
		String subject_e = request.getParameter("subject5")+","+request.getParameter("a_cv5")+","+request.getParameter("a_ue5")+","+request.getParameter("a_ia5")+","+request.getParameter("a_twp5")+","+request.getParameter("a_two5")+","+request.getParameter("a_result5")+","+request.getParameter("a_gp5");
		String subject_f = request.getParameter("subject6")+","+request.getParameter("a_cv6")+","+request.getParameter("a_ue6")+","+request.getParameter("a_ia6")+","+request.getParameter("a_twp6")+","+request.getParameter("a_two6")+","+request.getParameter("a_result6")+","+request.getParameter("a_gp6");
		String subject_g = request.getParameter("subject7")+","+request.getParameter("a_cv7")+","+request.getParameter("a_ue7")+","+request.getParameter("a_ia7")+","+request.getParameter("a_twp7")+","+request.getParameter("a_two7")+","+request.getParameter("a_result7")+","+request.getParameter("a_gp7");
		
		Result result=new Result(username, subject_a,subject_b, subject_c, subject_d,subject_e, subject_f, subject_g);
		request.setAttribute("result", result);
		Result result1=(Result)request.getAttribute("result");
		
		if(daafobsServices.acceptResult(result1)){
			request.getRequestDispatcher("ANALysis").forward(request, response);
		}
		else{
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
	}

}
