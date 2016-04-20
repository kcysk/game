package net.keshen.frame.test;

import net.keshen.logger.Logger;
import net.keshen.logger.LoggerManager;

/**
 * @author shenke
 * @date 2016-4-20 上午11:17:27
 */
public class TestLogger {

	private static final Logger logger = LoggerManager.getLogger(TestLogger.class);
	
	private static TestLogger testLogger;
	
	private TestLogger(){}
	
	public static void main(String[] args) {
		ManagerTestLogger.getManager();
	}
}
