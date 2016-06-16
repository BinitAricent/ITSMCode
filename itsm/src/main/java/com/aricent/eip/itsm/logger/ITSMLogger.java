/**************************************************************************
 
 **************************************************************************
 * Project: ITSM
 *
 * Class:   UserLogger.java
 *
 * Author:  Aricent 
 *
 * Date:    16/05/2016
 *
 * Desc:    Using for Logger
 *
 **************************************************************************
 *
 * $Revision: 1.0 $
 * adding comment for testing GIT
 * 
 **************************************************************************/

package com.aricent.eip.itsm.logger;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class ITSMLogger {
	
	private final static Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	
	/*
	 * Setting Highest lavel - severe
	 * 
	 */
	
	public void severe(String str){
		LOGGER.setLevel(Level.SEVERE);
		LOGGER.severe(str);
	}
	
	
	/*
	 * Setting warning lavel
	 * 
	 */
	public void warning(String str){
		LOGGER.setLevel(Level.WARNING);
		LOGGER.warning(str);
	}
	
	
	/*
	 * Setting info lavel and print the message in info lavel
	 * 
	 * 
	 */
	
	public void info(String str){
		LOGGER.setLevel(Level.INFO);
		LOGGER.info(str);
	}
	
	
	/*
	 * Setting config lavel and print the message in info lavel
	 * 
	 */
	
	public void config(String str){
		LOGGER.setLevel(Level.CONFIG);
		LOGGER.config(str);
	}
	
	/*
	 * Setting fine lavel and print the message in info lavel
	 * 
	 */
	
	public void fine(String str){
		LOGGER.setLevel(Level.FINE);
		LOGGER.config(str);
	}
	
	
	/*
	 * Setting finer lavel and print the message in info lavel
	 * 
	 */
	public void finer(String str){
		LOGGER.setLevel(Level.FINER);
		LOGGER.config(str);
	}	
	
	
	/*
	 * Setting finest  lavel and print the message in info lavel
	 * 
	 */
	
	public void finest(String str){
		LOGGER.setLevel(Level.FINEST);
		LOGGER.config(str);
	}
	
	
	/*
	 * passing Level and log msg in parameter 
	 */
	public void Logging(Level level, String msg){
		LOGGER.setLevel(level);
		LOGGER.config(msg);
	}
	
}
