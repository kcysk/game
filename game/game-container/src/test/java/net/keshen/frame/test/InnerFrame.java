package net.keshen.frame.test;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author shenke
 * @date 2016年4月20日下午11:52:53
 * @version 1.0
 */
public class InnerFrame extends JFrame{
	
	public InnerFrame(){
		setSize(new Dimension(200, 400));
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);
		Container cp = getContentPane();
		((JPanel)cp).setOpaque(false);
		//setOpacity(0);
		JKeyListener listener;
		this.addKeyListener((listener = new JKeyListener() {
			
			private JFrame frame;
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
					frame.setVisible(false);
				}
				System.out.println("esc");
			}
			
			@Override
			public void setJFrame(JFrame frame) {
				this.frame = frame;
				
			}
		}));
		listener.setJFrame(this);
	}

	interface JKeyListener extends KeyListener{
		
		public void setJFrame(JFrame frame);
		
	}
}
