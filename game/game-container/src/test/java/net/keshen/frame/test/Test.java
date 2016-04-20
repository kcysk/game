package net.keshen.frame.test;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import net.keshen.base.basecomponet.GameConstant;
import net.keshen.base.surface.GameSurface;
import net.keshen.fishgame.componets.ButtonAdapter;
import net.keshen.fishgame.config.Configuration;
import net.keshen.fishgame.manager.ComponetsManager;
import net.keshen.fishgame.manager.LayoutManager;

public class Test extends JFrame{

	
	public static void main(String[] args) throws Exception {
		Configuration.newInstance().init();
		System.out.println(System.getProperty("bg_0"));
		//LoggerManager.init();
		GameConstant.setWidth(800);
		GameConstant.setHeight(480);
		ManagerTestLogger.getManager();
		ComponetsManager componetsManager = ComponetsManager.getComponetsManager();
		Test t = new Test();
		Dimension size = new Dimension(800, 580);
		t.setSize(size);
		//t.setUndecorated(true);
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
		surface.updatePicLayer(GameSurface.CHANGE_MODEL_ADD, 1, componetsManager.getBottom());
		surface.updatePicLayer(GameSurface.CHANGE_MODEL_ADD, 1, componetsManager.getAddButton());
		surface.updatePicLayer(GameSurface.CHANGE_MODEL_ADD, 1, componetsManager.getRedButton());
		}
		surface.setVisible(true);
		i++;
		t.setContentPane(surface);
		t.setVisible(true);
		surface.action();
//		new Thread(()->surfa6ce.updateUI()).start();
		ButtonAdapter adapter = new ButtonAdapter();
	}
}
