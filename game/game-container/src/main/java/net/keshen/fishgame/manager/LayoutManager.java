package net.keshen.fishgame.manager;

import net.keshen.base.basecomponet.Componet;
import net.keshen.base.basecomponet.GameConstant;
import net.keshen.fishgame.componets.Bottom;
import net.keshen.fishgame.componets.BottomGold;
import net.keshen.fishgame.componets.BottomTime;
import net.keshen.fishgame.componets.Cannon;

/**
 * 布局管理器
 * 
 * @author shenke
 * @date 2016-3-9 下午1:27:56
 */
public class LayoutManager {

	private ComponetsManager componetsManager;
	private static LayoutManager layoutManager;
	private CannoManager cannoManager;

	/**
	 * 获取LayｏｕｔＭａｎａｇｅｒ
	 * @return
	 */
	public static LayoutManager getLayoutManager(){
		if(layoutManager==null){
			layoutManager = new LayoutManager();
		}
		return layoutManager;
	}
	
	/**
	 * IOC注入ComponetsManager实例
	 * @param componetsManager
	 */
	public void setComponetsManager(ComponetsManager componetsManager){
		this.componetsManager = componetsManager;
	}
	
	/**
	 * IOC注入CannoManager实例
	 * @param cannoManager
	 */
	public void setCannoManager(CannoManager cannoManager){
		this.cannoManager = cannoManager;
	}
	
	private LayoutManager(){
		
	}
	
	public void setComponetsLayout(){
		setCannonBottomLayout();
		setCannonVersionAdd();
		setCannonVersionRed();
		setBottomGoldLayout();
		setBottomTimeLayout();
		//setCannoLayout();
	}
	
	// 设置大炮底座位置
	public void setCannonBottomLayout() {
		Bottom bottom = componetsManager.getBottom();
		bottom.setLayout_x(GameConstant.getWidth() / 2 - bottom.getPicWidth() / 2);
		bottom.setLayout_y(GameConstant.getHeight() - bottom.getPicHeight() / 2);
		bottom.getPicMatrix().setTranslate(bottom.getLayout_x(), bottom.getLayout_y());
	}

	// 设置大炮的型号调整按钮的位置
	public void setCannonVersionAdd() {
		Componet addButton = componetsManager.getAddButton();
		addButton.setLayout_x(componetsManager.getBottom().getLayout_x() + componetsManager.getBottom().getPicWidth());
		addButton.setLayout_y(componetsManager.getBottom().getLayout_y());
		addButton.getPicMatrix().setTranslate(addButton.getLayout_x(), addButton.getLayout_y());
	}

	public void setCannonVersionRed() {
		Componet redButton = componetsManager.getRedButton();
		redButton.setLayout_x(componetsManager.getBottom().getLayout_x() - redButton.getPicWidth());
		redButton.setLayout_y(componetsManager.getBottom().getLayout_y());
		redButton.getPicMatrix().setTranslate(redButton.getLayout_x(), redButton.getLayout_y());
	}

	// 设置大炮旋转点位置
	public void setCannoLayout(){
		Cannon cannon = cannoManager.getCurrentCannon();
		cannon.setCannoRotate_x(componetsManager.getBottom().getLayout_x() + cannon.getPicWidth()/2);
		cannon.setCannoRotate_y(componetsManager.getBottom().getLayout_y() + cannon.getPicHeight()/2);
//		cannon.getPicMatrix().setTranslate(cannon.getR, y);
	}
	
	// 设置计时器位置
	public void setBottomTimeLayout() {
		BottomTime bottomTime = componetsManager.getBottomTime();
		bottomTime.setLayout_x(componetsManager.getRedButton().getLayout_x() - bottomTime.getPicWidth());
		bottomTime.setLayout_y(GameConstant.getHeight()-bottomTime.getPicHeight()/2);
		bottomTime.getPicMatrix().setTranslate(bottomTime.getLayout_x(), bottomTime.getLayout_y());
	}

	// 设置金币显示位置
	public void setBottomGoldLayout() {
		BottomGold bottomGold = componetsManager.getBottomGold();
		bottomGold.setLayout_x(componetsManager.getAddButton().getLayout_x()+componetsManager.getAddButton().getPicWidth());
		bottomGold.setLayout_y(GameConstant.getHeight() - bottomGold.getPicHeight()/2);
		bottomGold.getPicMatrix().setTranslate(bottomGold.getLayout_x(), bottomGold.getLayout_y());
	}
	// 设置FPS、当前时间等位置
	
	public void setFpsLayout(){
		
	}
	
	public void setTimeLayout(){
		
	}
}
