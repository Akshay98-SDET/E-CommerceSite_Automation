package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojos.Config;
import com.ui.pojos.Enviorment;

public class JSONUtility {

	public static String readJSON(Env env) {
		
		
		Gson gson = new Gson();
		File jsonfile = new File(System.getProperty("user.dir")+"\\config\\config.json"); //point to file
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                                 // read the file
		Enviorment enviorment = gson.fromJson(fileReader, Config.class).getEnviorments().get("QA");                   // file and its java class
		//Enviorment enviornment = config.getEnviorments().get("QA");
		
		return enviorment.getUrl();
		
	}

}
