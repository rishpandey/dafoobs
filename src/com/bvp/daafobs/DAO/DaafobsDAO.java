package com.bvp.daafobs.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bvp.daafobs.beans.Result;
import com.bvp.daafobs.beans.Student;
import com.bvp.daafobs.beans.Subject;


public interface DaafobsDAO {
	
	
	public boolean validateStudent(Student student);

	public ArrayList<Subject> reteriveSubject(String name);
	
	public ArrayList<String> reteriveSubjectBySem(String name);
	
	public boolean insertResult(Result result);
	
	public String analyzeBySubject(String subject,int semester, int year);
	
	public String analyzeBySemester(int semester);

	public String analyzeByYear(String yearStart, String yearEnd);

}
