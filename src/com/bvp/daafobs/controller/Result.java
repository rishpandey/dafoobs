package com.bvp.daafobs.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bvp.daafobs.connectionprovider.ConnectionProvider;

/**
 * Servlet implementation class Result
 */
public class Result extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			String subject_a = request.getParameter("subject1")+","+request.getParameter("a_cv1")+","+request.getParameter("a_ue1")+","+request.getParameter("a_ia1")+","+request.getParameter("a_twp1")+","+request.getParameter("a_two1")+","+request.getParameter("a_result1")+","+request.getParameter("a_gp1");
			String subject_b = request.getParameter("subject2")+","+request.getParameter("a_cv2")+","+request.getParameter("a_ue2")+","+request.getParameter("a_ia2")+","+request.getParameter("a_twp2")+","+request.getParameter("a_two2")+","+request.getParameter("a_result2")+","+request.getParameter("a_gp2");
			String subject_c = request.getParameter("subject3")+","+request.getParameter("a_cv3")+","+request.getParameter("a_ue3")+","+request.getParameter("a_ia3")+","+request.getParameter("a_twp3")+","+request.getParameter("a_two3")+","+request.getParameter("a_result3")+","+request.getParameter("a_gp3");
			String subject_d = request.getParameter("subject4")+","+request.getParameter("a_cv4")+","+request.getParameter("a_ue4")+","+request.getParameter("a_ia4")+","+request.getParameter("a_twp4")+","+request.getParameter("a_two4")+","+request.getParameter("a_result4")+","+request.getParameter("a_gp4");
			String subject_e = request.getParameter("subject5")+","+request.getParameter("a_cv5")+","+request.getParameter("a_ue5")+","+request.getParameter("a_ia5")+","+request.getParameter("a_twp5")+","+request.getParameter("a_two5")+","+request.getParameter("a_result5")+","+request.getParameter("a_gp5");
			String subject_f = request.getParameter("subject6")+","+request.getParameter("a_cv6")+","+request.getParameter("a_ue6")+","+request.getParameter("a_ia6")+","+request.getParameter("a_twp6")+","+request.getParameter("a_two6")+","+request.getParameter("a_result6")+","+request.getParameter("a_gp6");
			String subject_g = request.getParameter("subject7")+","+request.getParameter("a_cv7")+","+request.getParameter("a_ue7")+","+request.getParameter("a_ia7")+","+request.getParameter("a_twp7")+","+request.getParameter("a_two7")+","+request.getParameter("a_result7")+","+request.getParameter("a_gp7");
			session.getAttribute("id");
			Connection con = ConnectionProvider.getConnection();
			String sql = "insert into result values(?,?,?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, 100);
				pstmt.setString(2, subject_a);
				pstmt.setString(3, subject_b);
				pstmt.setString(4, subject_c);
				pstmt.setString(5, subject_d);
				pstmt.setString(6, subject_e);
				pstmt.setString(7, subject_f);
				pstmt.setString(8, subject_g);
				pstmt.setString(9, "PASS");
				pstmt.setInt(10, new Date().getYear());
				pstmt.execute();
				request.getRequestDispatcher("ANALysis").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
