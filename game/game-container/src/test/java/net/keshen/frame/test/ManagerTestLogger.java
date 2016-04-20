package net.keshen.frame.test;

import net.keshen.logger.Logger;
import net.keshen.logger.LoggerManager;

/**
 * @author shenke
 * @date 2016-4-20 下午1:47:00
 */
public class ManagerTestLogger {

	private static final Logger logger = LoggerManager.getLogger(ManagerTestLogger.class);
	
	private static ManagerTestLogger manager;
	
	private ManagerTestLogger(){
		
	}
	
	public static ManagerTestLogger getManager(){
		if(manager==null){
			manager = new ManagerTestLogger();
		}
		return manager;
	}
}
