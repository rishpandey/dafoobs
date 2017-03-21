package com.bvp.daafobs.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bvp.daafobs.DAO.DaafobsDAO;
import com.bvp.daafobs.beans.Result;
import com.bvp.daafobs.beans.Student;
import com.bvp.daafobs.beans.Subject;
import com.bvp.daafobs.connectionprovider.ConnectionProvider;

public class DaafobsDAOImpl implements DaafobsDAO {

	Connection daafobsconnection = null;

	public DaafobsDAOImpl() {

		daafobsconnection = ConnectionProvider.getConnection();
	}

	@Override
	public boolean validateStudent(Student student) {

		String name = student.getName();
		String password = student.getPassword();
		int x = 0;
		String str = "select * from student where prn = ? AND login_pass = ?";

		try {
			PreparedStatement pstmt = daafobsconnection.prepareStatement(str);
			pstmt.setString(1, name);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				x = 1;
			} else
				x = 0;

			if (x > 0) {
				return true;
			} else
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Subject> reteriveSubject(String name) {

		String semester = null;
		
		System.out.println("naaaamee "+name);
		String str1 = "select * from student where prn=?";
		PreparedStatement pst;

		try {
			pst = daafobsconnection.prepareStatement(str1);

			pst.setString(1, name);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				semester = rs.getString(4);
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		System.out.println("in dao" + semester);

		ArrayList<Subject> arr = new ArrayList<Subject>();
		String str = "select * from subject where semester = ?";

		PreparedStatement pstmt;
		try {
			pstmt = daafobsconnection.prepareStatement(str);
			pstmt.setString(1, semester);

			ResultSet rs1 = pstmt.executeQuery();

			while (rs1.next()) {
				Subject subject1 = new Subject();
				subject1.setSubject1(rs1.getString(2));

				arr.add(subject1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arr;

	}

	@Override
	public boolean insertResult(Result result) {
	
		String semester = null;
		String username=result.getPrn();
		String subject1=result.getSubject1();
		String subject2=result.getSubject2();
		String subject3=result.getSubject3();
		String subject4=result.getSubject4();
		String subject5=result.getSubject5();
		String subject6=result.getSubject6();
		String subject7=result.getSubject7();
		
		String str1 = "select * from student where prn=?";
		PreparedStatement pst;

		try {
			pst = daafobsconnection.prepareStatement(str1);

			pst.setString(1, username);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				semester = rs.getString(4);
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		
		String sql="insert into result values(?,?,?,?,?,?,?,?,?,?,?)";
		String res="pass";
		PreparedStatement pstmt;
		try {
			pstmt=daafobsconnection.prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2, subject1);
			pstmt.setString(3, subject2);
			pstmt.setString(4, subject3);
			pstmt.setString(5, subject4);
			pstmt.setString(6, subject5);
			pstmt.setString(7, subject6);
			pstmt.setString(8, subject7);
			pstmt.setString(9, res);
			pstmt.setString(10,semester);
			pstmt.setString(11, "2017");
			pstmt.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	@Override
	public ArrayList<String> reteriveSubjectBySem(String semester) {
		ArrayList<String> arr = new ArrayList<String>();
		String str = "select name from subject where semester = ?";

		PreparedStatement pstmt;
		try {
			pstmt = daafobsconnection.prepareStatement(str);
			pstmt.setString(1, semester);

			ResultSet rs1 = pstmt.executeQuery();

			while (rs1.next()) {
				arr.add(rs1.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arr;	
		
	}

	@Override
	public String analyzeBySubject(String subject,int semester, int year) {
		String arr = "";
		String str = "select subject"+subject+" from result where class=? and year=?";

		PreparedStatement pstmt;
		try {
			pstmt = daafobsconnection.prepareStatement(str);
			pstmt.setString(1, semester+"");
			pstmt.setString(2, year+"");
			ResultSet rs1 = pstmt.executeQuery();

			while (rs1.next()) {
				arr+=(rs1.getString(1))+"|";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;	

	}

	@Override
	public String analyzeBySemester(int semester) {
		
		String arr="";
		String str = "select * from result where class=?";
		PreparedStatement pstmt;
		try {
			pstmt = daafobsconnection.prepareStatement(str);
			pstmt.setString(1, semester+"");
			ResultSet rs1 = pstmt.executeQuery();

			while (rs1.next()) {
				arr+=rs1.getString(2)+","+ rs1.getString(3)+","+rs1.getString(4)+","+rs1.getString(5)+","+rs1.getString(6)+","+rs1.getString(7)+","+rs1.getString(8)+",";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;	
	
	}
	
	@Override
	public String analyzeByYear(String yearStart, String yearEnd) {
		String arr="";
		String str = "select * from result where year>="+yearStart+" AND year<="+yearEnd+"";
		PreparedStatement pstmt;
		try {
			pstmt = daafobsconnection.prepareStatement(str);
			ResultSet rs1 = pstmt.executeQuery();

			while (rs1.next()) {
				arr+=rs1.getString(10)+","+rs1.getString(9)+"..";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;	
	
	}

}