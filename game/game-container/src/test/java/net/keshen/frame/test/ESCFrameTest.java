package net.keshen.frame.test;

import java.awt.Graphics;

import javax.swing.JPanel;

import net.keshen.fishgame.frame.ESCFrame;

/**
 * @author shenke
 * @date 2016-4-21 上午10:53:49
 */
public class ESCFrameTest {

	public static void main(String[] args) {
		ESCFrame frame = new ESCFrame();
		frame.setSize(200, 200);
		frame.setTransparent(true);
		frame.setVisible(true);
	}
}
