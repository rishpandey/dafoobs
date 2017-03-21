package com.bvp.daafobs.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bvp.daafobs.connectionprovider.ConnectionProvider;

public class Analysis extends HttpServlet {
	Connection con = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			con = ConnectionProvider.getConnection();
			ResultSet rs = con.createStatement().executeQuery("select * from result where prn='100'");
			System.out.println(rs.next());
			String subject_a = rs.getString(2);
			String result_a[] = subject_a.split(",");
			for (String key : result_a) {
				response.getWriter().println(key);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			con = ConnectionProvider.getConnection();
			ResultSet rs = con.createStatement().executeQuery("select * from result where prn='100'");
			System.out.println(rs.next());
			String subject_a = rs.getString(2);
			String result_a[] = subject_a.split(",");
			for (String key : result_a) {
				response.getWriter().println(key);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
