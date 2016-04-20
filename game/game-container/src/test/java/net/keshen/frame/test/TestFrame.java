package net.keshen.frame.test;

import javax.swing.JFrame;

import net.keshen.fishgame.config.Configuration;

/**
 * @author shenke
 * @date 2016-4-20 下午1:54:22
 */
public class TestFrame extends JFrame{

	public static void main(String[] args) {
		Configuration.newInstance();
		ManagerTestLogger.getManager();
	}
}
