package net.keshen.window.test;

import javax.swing.JFrame;
import javax.swing.JWindow;

/**
 * @author shenke
 * @date 2016-4-21 下午4:15:35
 */
public class JWindowTest extends JFrame{

	public static void main(String[] args) {
		JWindow window = new JWindow();
		window.setSize(200, 200);
		window.setVisible(true);
		
		JWindowTest frame = new JWindowTest();
		frame.setSize(200, 200);
		frame.add(window);
		frame.setVisible(true);
	}
}
