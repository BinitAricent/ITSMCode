/**************************************************************************
 
 **************************************************************************
 * Project: ITSM
 *
 * Class:   ITSMLogger
 *
 * Author:  Aricent 
 *
 * Date:    16/05/2016
 *
 * Desc:    using for setup the ITSMLogger
 *
 **************************************************************************
 *
 * $Revision: 1.0 $
 * 
 **************************************************************************/

package com.aricent.eip.itsm.logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ITSMSetup {

	static private FileHandler filetxt;

	/*
	 * @Value("${itsmlog}") static String itsmlog;
	 */

	static public void setup() throws IOException {

		// get the global logger to configure it

		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

		// getting itsmlog path from application.properties
		Properties prop = new Properties();
		String itsmLogPath;

		InputStream inputStream = ITSMSetup.class.getClassLoader()
				.getResourceAsStream("application.properties");
		prop.load(inputStream);
		itsmLogPath = prop.getProperty("itsmlog");

		System.out.println("ITSM LOG PATH:" + itsmLogPath);

		filetxt = new FileHandler(itsmLogPath);

		// filetxt=new FileHandler("./itsm.log");

		// filetxt=new FileHandler(itsmlog);
		// simpleFormatter
		SimpleFormatter formater = new SimpleFormatter();
		logger.addHandler(filetxt);
		filetxt.setFormatter(formater); // log log msg in text file
	}

}
