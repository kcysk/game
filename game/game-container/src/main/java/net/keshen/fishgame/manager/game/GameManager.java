package net.keshen.fishgame.manager.game;

import java.awt.Dimension;
import java.awt.Toolkit;

import net.keshen.base.basecomponet.GameConstant;
import net.keshen.fishgame.config.Configuration;
import net.keshen.logger.Logger;
import net.keshen.logger.LoggerManager;


/**
 * 游戏调度管理器
 * @author shenke
 * @date 2016-3-7 下午3:04:22
 */
public class GameManager {
	
	//private Logger logger = LoggerManager.getLogger(getClass());
	
	private static GameManager gameManager;
	
	private static boolean pause = false;
	private static boolean run = true;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static GameManager newInstance(){
		if(gameManager==null)
		{
			gameManager = new GameManager();
		}
		return gameManager;
	}
	
	private GameManager(){
		
	}
	
	//初始化游戏相关参数
	public void initGame(){
		
		System.out.println("游戏初始化中。。。");
		
		Configuration.newInstance().init();
		
		GameConstant.setFps(true);
		GameConstant.setQuality(true);
		GameConstant.setTime(true);
		//GameConstant.setWidth((int)screenSize.getWidth());
		GameConstant.setWidth(700);
		System.out.println("游戏窗口宽度："+GameConstant.getWidth());
		//GameConstant.setHeight((int)screenSize.getHeight());
		GameConstant.setHeight(500);
		System.out.println("游戏窗口高度："+GameConstant.getHeight());
		
		//Toolkit.getDefaultToolkit().
		
	}
	
	/**
	 * 游戏是否暂停
	 * @return true暂停，false
	 */
	public static boolean isPause(){
		return pause;
	}
	
	/**
	 * 游戏是否正在运行
	 * @return
	 */
	public static boolean isRunning(){
		return run;
	}
	
	/**
	 * 暂停游戏
	 */
	public static void pause(){
		pause = true;
	}
	
	/**
	 * 终止游戏
	 */
	public static void gameOver(){
		run = false;
	}
	
}
