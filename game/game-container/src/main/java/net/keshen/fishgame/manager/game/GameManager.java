package net.keshen.fishgame.manager.game;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import net.keshen.base.basecomponet.GameConstant;
import net.keshen.container.ApplicationContext;
import net.keshen.fishgame.config.Configuration;
import net.keshen.fishgame.manager.CannoManager;
import net.keshen.fishgame.manager.ComponetsManager;
import net.keshen.fishgame.manager.ImageManager;
import net.keshen.fishgame.manager.LayoutManager;
import net.keshen.fishgame.model.HeadFish;


/**
 * 游戏调度管理器
 * @author shenke
 * @date 2016-3-7 下午3:04:22
 */
public class GameManager {
	
	//private Logger logger = LoggerManager.getLogger(getClass());
	
	private static GameManager gameManager;
	
	private List<HeadFish> shoal = new ArrayList<HeadFish>();
	
	private static boolean pause = false;
	private static boolean run = true;
	
	private int nowPart ;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static GameManager newInstance(){
		if(gameManager==null)
		{
			gameManager = new GameManager();
			ApplicationContext.putBean(GameManager.class, gameManager);
		}
		return gameManager;
	}
	
	private GameManager(){
		
	}
	
	//初始化游戏相关参数
	public void initGame(){
		
		System.out.println("游戏初始化中。。。");
		
		Configuration.newInstance().init();
		nowPart = 1;
		GameConstant.setFps(true);
		GameConstant.setQuality(true);
		GameConstant.setTime(true);
		GameConstant.setWidth((int)screenSize.getWidth());
		//GameConstant.setWidth(700);
		System.out.println("游戏窗口宽度："+GameConstant.getWidth());
		GameConstant.setHeight((int)screenSize.getHeight());
		//GameConstant.setHeight(500);
		System.out.println("游戏窗口高度："+GameConstant.getHeight());
		
		
		ApplicationContext.putBean(ImageManager.class, ImageManager.getImageManager().init());
		ApplicationContext.putBean(ComponetsManager.class, ComponetsManager.newInstance());
		ApplicationContext.putBean(CannoManager.class, CannoManager.newInstance().init());
		ApplicationContext.putBean(LayoutManager.class, LayoutManager.newInstance().setComponetsLayout());
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
	
	public List<HeadFish> getShoals(){
		return shoal;
	}

	/**
	 * 当前关卡
	 * @return
	 */
	public int getNowPart() {
		return nowPart;
	}
	
}
