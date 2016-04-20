package net.keshen.fishgame.manager;


import net.keshen.base.OnClickListener;
import net.keshen.base.basecomponet.Componet;
import net.keshen.fishgame.componets.Background;
import net.keshen.fishgame.componets.Bottom;
import net.keshen.fishgame.componets.BottomGold;
import net.keshen.fishgame.componets.BottomTime;
import net.keshen.fishgame.componets.ButtonAdapter;
import net.keshen.fishgame.componets.Cannon;
import net.keshen.logger.Logger;
import net.keshen.logger.LoggerManager;
import net.keshen.util.ImageUtils;

/**
 * 组件管理器
 * @author shenke
 * @date 2016-3-9 下午1:39:08
 */
public class ComponetsManager {

	private static Logger logger = LoggerManager.getLogger(ComponetsManager.class.getName());
	
	private static ComponetsManager manager;
	
	public static void main(String[] args) {
		logger.info("123");
	}
	private CannoManager cannoManager;
	
	private Bottom bottom;
	private BottomGold bottomGold;
	private BottomTime bottomTime;
	private Componet addButton;
	private Componet redButton;
	private Background background;
	
	private OnClickListener upListener;
	private OnClickListener downListener;
	
	public static ComponetsManager getComponetsManager(){
		if(manager==null){
			manager = new ComponetsManager();
		}
		return manager;
	}
	
	private ComponetsManager(){
		init();
	}
	
	//初始化所有组件
	private void init(){
		logger.info("组件初始化中.....");
		
		//初始化背景
		background = new Background();
		//初始化底座
		logger.info("初始化大炮底座...");
		bottom = new Bottom();
		bottom.setDrawableName("bottom");
		bottom.setBg(ImageUtils.getBitmapByAssert(bottom.getDrawableName()));
		//初始化金币框
		logger.info("初始化金币框...");
		bottomGold = new BottomGold();
		bottomGold.setDrawableName("bottom_gold");
		bottomGold.setBg(ImageUtils.getBitmapByAssert(bottomGold.getDrawableName()));
		//初始化计时器
		logger.info("初始化计时器...");
		bottomTime = new BottomTime();
		bottomTime.setDrawableName("bottom_time");
		bottomTime.setBg(ImageUtils.getBitmapByAssert(bottomTime.getDrawableName()));
		//初始化大炮型号调整按钮
		logger.info("初始化大炮型号调整按钮...");
		addButton = new ButtonAdapter();
		addButton.setDrawableName("add");
		addButton.setBg(ImageUtils.getBitmapByAssert(addButton.getDrawableName()));
		((ButtonAdapter)addButton).addOnClickListener(this.upListener);
		
		redButton = new ButtonAdapter();
		redButton.setDrawableName("sub");
		redButton.setBg(ImageUtils.getBitmapByAssert(redButton.getDrawableName()));
		((ButtonAdapter)redButton).addOnClickListener(this.downListener);
		logger.info("组件初始化结束......");
		
		initCanno();
	}
	
	private void initCanno(){
		//初始化大炮
		Cannon cannon = new Cannon();
		cannon.setDrawableName("fire");
		
//		cannon.setCannoImage(cannoImage);
	}
	/**
	 * 获取大炮底座
	 * @return
	 */
	public Bottom getBottom(){
		return this.bottom;
	}
	
	/**
	 * 获取金币底座
	 * @return
	 */
	public BottomGold getBottomGold(){
		return this.bottomGold;
	}
	
	/**
	 * 获取计时器底座
	 * @return
	 */
	public BottomTime getBottomTime(){
		return this.bottomTime;
	}
	
	/**
	 * 获取增加大炮型号的按钮底座
	 * @return
	 */
	public Componet getAddButton(){
		return this.addButton;
	}
	
	/**
	 * 获取减小大炮型号的按钮
	 * @return
	 */
	public Componet getRedButton(){
		return this.redButton;
	}
	
	/**
	 * addButton 点击事件监听器
	 * @param upListener
	 */
	public void setUpCannonListener(OnClickListener upListener){
		this.upListener = upListener;
	}
	
	/**
	 * redButton 点击事件监听器
	 * @param downListener
	 */
	public void setDownCannonListener(OnClickListener downListener){
		this.downListener = downListener;
	}
	
	/**
	 * ＩＯＣ 注入大炮管理器
	 * @param cannoManager
	 */
	public void setCannoManager(CannoManager cannoManager){
		this.cannoManager = cannoManager;
	}
	
	public Background getBackground() {
		return background;
	}
}