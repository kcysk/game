package net.keshen.logger;

import java.util.Map.Entry;
import java.util.Properties;

import org.junit.Test;

/**
 * @author shenke
 * @date 2016-3-29 下午3:29:51
 */
public class LoadLogPropertiesTest {

	
	@Test
	public void testLoad() throws InterruptedException{
		System.out.print(System.getProperty("net.keshen.logger"));
		//LoggerManager.getLogger(LoadLogPropertiesTest.class).info("ceshi");
		Thread.sleep(500);
		logger();
	}
	
	public void logger(){
		LoggerManager.getLogger(LoadLogPropertiesTest.class).info("ceshi");
	}
	
}
