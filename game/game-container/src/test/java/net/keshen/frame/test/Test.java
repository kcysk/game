package net.keshen.frame.test;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

import net.keshen.base.basecomponet.GameConstant;
import net.keshen.base.surface.GameSurface;
import net.keshen.container.ApplicationContext;
import net.keshen.fishgame.componets.ButtonAdapter;
import net.keshen.fishgame.frame.ESCWindow;
import net.keshen.fishgame.manager.CannoManager;
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
		final Test t = new Test();
		Dimension size = new Dimension(GameConstant.getWidth(), GameConstant.getHeight());
		t.setSize(size);
		t.setUndecorated(true);
		t.setDefaultCloseOperation(EXIT_ON_CLOSE);
		t.setLocationRelativeTo(null);
		Container cp = t.getContentPane();
		//((JPanel)cp).setOpaque(false);
		GameSurface surface = new GameSurface();
		ApplicationContext.putBean(GameSurface.class, surface);
		int i = 0;
		if(i==0){
			ComponetsManager componetsManager = ApplicationContext.getBean(ComponetsManager.class);
			CannoManager cannoManager = ApplicationContext.getBean(CannoManager.class);
			componetsManager.getBackground().setBg(ImageUtils.getBitmapByAssertNoPath("bg_0"));
			surface.updatePicLayer(GameSurface.CHANGE_MODEL_ADD, 1, componetsManager.getBackground());
			surface.updatePicLayer(GameSurface.CHANGE_MODEL_ADD, 1, componetsManager.getBottom());
			surface.updatePicLayer(GameSurface.CHANGE_MODEL_ADD, 1, componetsManager.getAddButton());
			surface.updatePicLayer(GameSurface.CHANGE_MODEL_ADD, 1, componetsManager.getRedButton());
			surface.updatePicLayer(GameSurface.CHANGE_MODEL_ADD, 1, cannoManager.getCurrentCannon());
		}
		surface.setVisible(true);
		i++;
		t.setContentPane(surface);
		t.setVisible(true);
		surface.action();
		final ESCWindow ifFrame = new ESCWindow();
		//ifFrame.setVisible(false);
		//t.add(ifFrame);
//		new Thread(()->surfa6ce.updateUI()).start();
		ButtonAdapter adapter = new ButtonAdapter();
		t.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE&&!ifFrame.isVisible()){
					ifFrame.setVisible(true);
					ifFrame.setAlwaysOnTop(true);
					//ifFrame.setFocusable(false);
					GameManager.pause();
					t.setFocusable(true);
					System.out.println("1232142");
				}else if(e.getKeyCode()==KeyEvent.VK_ESCAPE&&ifFrame.isVisible()){
					ifFrame.setVisible(false);
					//t.setFocusable(true);
//					GameManager.
				}
				
			}
		});
		t.addWindowFocusListener(new WindowFocusListener() {
			
			public void windowLostFocus(WindowEvent e) {
				ifFrame.setVisible(false);
				
			}
			
			public void windowGainedFocus(WindowEvent e) {
				if(GameManager.isPause()){
					ifFrame.setVisible(true);
				}
			}
		});
		t.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				CannoManager cannoManager = ApplicationContext.getBean(CannoManager.class);
				cannoManager.downCannonVersion();
				System.out.println(cannoManager.getCurrentCannon().getType().getVersion());
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
}
