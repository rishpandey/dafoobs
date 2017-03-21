package com.bvp.daafobs.providers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.bvp.daafobs.services.DaafobsServices;


public class DaafobsServiceProvider {
	
	
	public static DaafobsServices getServiceProvider() {
		File file = null;
		FileReader fr = null;
		Properties properties = null;
		String provider = null;
		DaafobsServices daafobsServices = null;
		try {
			file = new File("d:\\provider1.properties");
			fr = new FileReader(file);
			properties = new Properties();
			properties.load(fr);
			provider = properties.getProperty("provider");
			daafobsServices = (DaafobsServices) Class.forName(provider).newInstance();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return daafobsServices;
	}


}
