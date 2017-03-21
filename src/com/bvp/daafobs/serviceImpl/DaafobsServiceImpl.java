package com.bvp.daafobs.serviceImpl;

import java.util.ArrayList;

import com.bvp.daafobs.DAO.DaafobsDAO;
import com.bvp.daafobs.beans.Result;
import com.bvp.daafobs.beans.Student;
import com.bvp.daafobs.beans.Subject;
import com.bvp.daafobs.providers.DaafobsDAOProvider;
import com.bvp.daafobs.services.DaafobsServices;

public class DaafobsServiceImpl implements DaafobsServices {

	DaafobsDAO daafobsDAO = null;

	public DaafobsServiceImpl() {
		daafobsDAO = DaafobsDAOProvider.getDAOProvider();
	}

	@Override
	public boolean loginStudent(Student student) {

		boolean flag = daafobsDAO.validateStudent(student);
		return flag;

	}

	@Override
	public ArrayList<Subject> displaySubject(String name) {
		ArrayList<Subject> arr;

		arr = daafobsDAO.reteriveSubject(name);
		return arr;
	}

	@Override
	public boolean acceptResult(Result result) {
		
		boolean flag=daafobsDAO.insertResult(result);
		return flag;
	}

}
