package net.keshen.frame.test;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import net.keshen.base.basecomponet.GameConstant;
import net.keshen.base.surface.GameSurface;
import net.keshen.fishgame.componets.ButtonAdapter;
import net.keshen.fishgame.manager.ComponetsManager;
import net.keshen.fishgame.manager.LayoutManager;
import net.keshen.fishgame.manager.game.GameManager;
import net.keshen.util.ImageUtils;

public class Test extends JFrame{

	
	public static void main(String[] args) throws Exception {
		
		//LoggerManager.init();
		GameManager.newInstance().initGame();
		//GameConstant.setWidth(800);
		//GameConstant.setHeight(480);
		//ManagerTestLogger.getManager();
		ComponetsManager componetsManager = ComponetsManager.getComponetsManager();
		final Test t = new Test();
		Dimension size = new Dimension(GameConstant.getWidth(), GameConstant.getHeight());
		t.setSize(size);
		t.setUndecorated(true);
		t.setDefaultCloseOperation(EXIT_ON_CLOSE);
		t.setLocationRelativeTo(null);
		Container cp = t.getContentPane();
		//((JPanel)cp).setOpaque(false);
		GameSurface surface = new GameSurface();
		LayoutManager layoutManager = LayoutManager.getLayoutManager();
		layoutManager.setComponetsManager(componetsManager);
		layoutManager.setComponetsLayout();
		int i = 0;
		if(i==0){
			componetsManager.getBackground().setBg(ImageUtils.getBitmapByAssertNoPath("bg_0"));
			surface.updatePicLayer(GameSurface.CHANGE_MODEL_ADD, 1, componetsManager.getBackground());
			surface.updatePicLayer(GameSurface.CHANGE_MODEL_ADD, 1, componetsManager.getBottom());
			surface.updatePicLayer(GameSurface.CHANGE_MODEL_ADD, 1, componetsManager.getAddButton());
			surface.updatePicLayer(GameSurface.CHANGE_MODEL_ADD, 1, componetsManager.getRedButton());
		}
		surface.setVisible(true);
		i++;
		t.setContentPane(surface);
		t.setVisible(true);
		surface.action();
		final InnerFrame ifFrame = new InnerFrame();
		ifFrame.setVisible(false);
		//t.add(ifFrame);
//		new Thread(()->surfa6ce.updateUI()).start();
		ButtonAdapter adapter = new ButtonAdapter();
		t.addKeyListener(new KeyListener() {
			
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
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE&&!ifFrame.isVisible()){
					ifFrame.setVisible(true);
					ifFrame.setAlwaysOnTop(true);
					//ifFrame.setFocusable(false);
					GameManager.pause();
					t.setFocusable(true);
				}else if(e.getKeyCode()==KeyEvent.VK_ESCAPE&&!ifFrame.isVisible()){
					ifFrame.setVisible(false);
					//t.setFocusable(true);
				}
				
			}
		});
	}
	
	
}
