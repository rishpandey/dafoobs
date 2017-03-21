package com.bvp.daafobs.providers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.bvp.daafobs.DAO.DaafobsDAO;


public class DaafobsDAOProvider {
	
	
	public static DaafobsDAO getDAOProvider() {

		File file = null;
		FileReader fr = null;
		Properties properties = null;
		String provider = null;
		DaafobsDAO daafobsDAO = null;

		file = new File("d:\\rprovider1.properties");
		try {
			fr = new FileReader(file);
			properties = new Properties();
			properties.load(fr);
			provider = properties.getProperty("provider");
			daafobsDAO = (DaafobsDAO) Class.forName(provider).newInstance();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return daafobsDAO;
	}

}
