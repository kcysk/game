package net.keshen.graphics;

import java.awt.Toolkit;

import org.junit.Test;

/**
 * @author shenke
 * @date 2016-4-20 上午10:41:25
 */
public class ToolKitTest {

	@Test
	public void testToolkit(){
		System.out.println(Toolkit.getDefaultToolkit().getScreenSize().height);
		System.out.println(Toolkit.getDefaultToolkit().getScreenSize().width);
		System.out.println();
		for (Object obj : System.getProperties().keySet()) {
			System.out.println(obj.toString()+"--"+System.getProperty(obj.toString()));
		}
	}
}
