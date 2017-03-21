package com.bvp.daafobs.services;

import java.util.ArrayList;

import com.bvp.daafobs.beans.Result;
import com.bvp.daafobs.beans.Student;
import com.bvp.daafobs.beans.Subject;

public interface DaafobsServices {

	
	public boolean loginStudent(Student student);
	public ArrayList<Subject> displaySubject(String name);
	public boolean acceptResult(Result result);
}
